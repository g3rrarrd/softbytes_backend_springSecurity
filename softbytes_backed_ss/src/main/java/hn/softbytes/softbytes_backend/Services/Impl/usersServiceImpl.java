package hn.softbytes.softbytes_backend.Services.Impl;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hn.softbytes.softbytes_backend.Models.address;
import hn.softbytes.softbytes_backend.Models.cities;
import hn.softbytes.softbytes_backend.Models.countries;
import hn.softbytes.softbytes_backend.Models.departments;
import hn.softbytes.softbytes_backend.Models.newUserJson;
import hn.softbytes.softbytes_backend.Models.users;
import hn.softbytes.softbytes_backend.Repositories.addressRepository;
import hn.softbytes.softbytes_backend.Repositories.authorityRepository;
import hn.softbytes.softbytes_backend.Repositories.citiesRepository;
import hn.softbytes.softbytes_backend.Repositories.countriesRepository;
import hn.softbytes.softbytes_backend.Repositories.departmentsRepository;
import hn.softbytes.softbytes_backend.Repositories.userTypeRepository;
import hn.softbytes.softbytes_backend.Repositories.usersRepository;
import hn.softbytes.softbytes_backend.Services.usersService;
import hn.softbytes.softbytes_backend.Utils.authorityRoles;

@Service
public class usersServiceImpl implements usersService{

    @Autowired
    private usersRepository usersRepository;

    @Autowired
    private userTypeRepository userTypeRepository;
    @Autowired 
    private addressRepository addressRepository;
    @Autowired
    private citiesRepository citiesRepository;
    @Autowired
        private PasswordEncoder passwordEncoder;
    @Autowired
    private authorityRepository authorityRepository;

    @Override
    public boolean crearCliente(newUserJson newUserJson) {
        
        List<address> addressList = new LinkedList<address>();
        address address = new address();
        users users = newUserJson.getUser();
        cities city = new cities();
        

        if(isValidateUser(users)){
           if(!this.usersRepository.findAll().isEmpty()){
             for (users user : this.usersRepository.findAll()) {
                if (user.getEmail().equals(users.getEmail())) {
                    return false;
                }
            }
           }
           
           city = this.econtrarCiudad(newUserJson.getCity());

            addressList.add(address);
            addressList.get(0).setAddress(newUserJson.getAddress());
            addressList.get(0).setZipCode(newUserJson.getZipCode());
            addressList.get(0).setIdCity(city);
            addressList.get(0).getIdCity().setDepartments(city.getDepartments());
            addressList.get(0).getIdCity().getDepartments().setIdCountry(city.getDepartments().getIdCountry());
            addressList.get(0).setIdUsers(users);
            users.setPassword(passwordEncoder.encode(users.getPassword()));
            users.setAddresses(addressList);
            users.setUsertype(this.userTypeRepository.findById(1).get());
            users.setUsername(this.obtenerUsername(users.getEmail()));
            users.setAuthorities(List.of(this.authorityRepository.findByName(authorityRoles.ROLE_USER).get()));
            this.usersRepository.saveAll(List.of(users));
            return true;
        }

        return false;
    }

    private cities econtrarCiudad(String nameCity){
        for (cities cities : this.citiesRepository.findAll()) {
            if(cities.getName().equals(nameCity)){
                return cities;
            }
        }
        return null;
    }

    
    private boolean isValidateUser(users users){
        if(users.getDateofBirth() != null
        && !users.getEmail().isEmpty() 
        && !users.getName().isEmpty() 
        && !users.getLastName().isEmpty()
        && !users.getPassword().isEmpty()
        && !users.getTelephone().isEmpty()){
            return true;
        }
        return false;
    }

    private String obtenerUsername(String email){

        String [] username = new String[2];

        if(email.contains("@")){
            username = email.split("@");
        }

        return username[0];

    }

    @Override
    public boolean modificarCliente(int id, users users) {
       
        users oldUser = new users();

        oldUser = this.usersRepository.findById(id).get();
        oldUser.setAddresses(users.getAddresses() != null ? users.getAddresses() : oldUser.getAddresses());
        oldUser.setPassword(users.getPassword() != null ? passwordEncoder.encode(users.getPassword()) : passwordEncoder.encode(oldUser.getPassword()));
        oldUser.setShippingPreference(users.getShippingPreference() != null ? users.getShippingPreference() : oldUser.getShippingPreference());
        oldUser.setContactInformation(users.getContactInformation() != null ? users.getContactInformation() : oldUser.getContactInformation());

        this.usersRepository.save(oldUser);
        return true;

        }

    @Override
    public int idCliente(String correo) {
        
        for (users user : this.usersRepository.findAll()) {
            
            if(user.getEmail().equals(correo)){
                return user.getIdUser();
            }

        }

        return -1;

    }

    @Override
    public boolean eliminarCliente(int id) {
       

        if(this.usersRepository.existsById(id)){

            try {
                this.usersRepository.deleteById(id);
                return true;
            } catch (Exception e) {
                e.printStackTrace(); 
                return false;
            }
            

        }

        return false;
    }

    @Override
    public users buscarCliente(int id) {
        
        users users = new users();

        if(this.usersRepository.findById(id)!=null){
            users = this.usersRepository.findById(id).get();
        }

        return users;
    }

    @Override
    public List<users> obtenerTodosClientes() {
        
        return this.usersRepository.findAll();

    }

    @Override
    public List<users> obtenerClientePorTipo(int id) {
        
        List<users> usersByType = new LinkedList<users>();

        for (users user : this.usersRepository.findAll()) {
            
           if(user.getUsertype() != null){
             if(user.getUsertype().getIdUserType() == id){
                usersByType.add(user);
            }
           }

        }

        return usersByType;

    }

    @Override
    public List<users> clientePorFecha(LocalDate fechaInicio, LocalDate fechaFinal) {
       
        List<users> usersByDate = new LinkedList<users>();

        for (users user : this.usersRepository.findAll()) {
            
           if(user.getDateofBirth() != null){
             if(user.getDateofBirth().isAfter(fechaInicio) && user.getDateofBirth().isBefore(fechaFinal)){
                usersByDate.add(user);
            }
           }

        }

        return usersByDate;

    }

    @Override
    public boolean isClientValidate(String email, String password) {
        
        for (users user : this.usersRepository.findAll()) {
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                return true;
            }
        }

        return false;

    }

    
}
