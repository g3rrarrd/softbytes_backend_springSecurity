package hn.softbytes.softbytes_backend.Services.Impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.softbytes.softbytes_backend.Models.address;
import hn.softbytes.softbytes_backend.Models.users;
import hn.softbytes.softbytes_backend.Repositories.addressRepository;
import hn.softbytes.softbytes_backend.Repositories.citiesRepository;
import hn.softbytes.softbytes_backend.Repositories.usersRepository;
import hn.softbytes.softbytes_backend.Services.addressService;

@Service
public class addressServiceImpl implements addressService{

    @Autowired
    private addressRepository addressRepository;
    @Autowired
    private citiesRepository citiesRepository;
    @Autowired
    private usersRepository usersRepository;

    @Override
    public boolean crearDireccion(int idCliente, int idCiudad,address address) {
        
        List<address> addressesList = new LinkedList<address>(); 
        users users = new users();

        if(this.usersRepository.findById(idCliente) != null && this.citiesRepository.findById(idCiudad) != null){
            addressesList = this.addressRepository.findAll();
            users = this.usersRepository.findById(idCliente).get();
            address.setIdCity(this.citiesRepository.findById(idCiudad).get());
            address.setIdUsers(users);
            addressesList.add(address);
            users.setAddresses(addressesList);
            this.addressRepository.save(address);
            this.usersRepository.save(users);
            return true;
        }

        return false;
    }

    @Override
    public address buscarDireccion(int id) {
        
        if(this.addressRepository.findById(id) != null){
            return this.addressRepository.findById(id).get();
        }

        return null;

    }

    @Override
    public List<address> obtenerDireciones() {
        
        if(this.addressRepository.findAll().size() > 0){
            return this.addressRepository.findAll();
        }

        return null;

    }

    @Override
    public boolean actualizarDireccion(int id, address address) {
        
        address oldAddress = new address();

        if(this.addressRepository.findById(id) != null){
            oldAddress = this.addressRepository.findById(id).get();
            if(address.getAddress().length() > 0){
                oldAddress.setAddress(address.getAddress());
            }
            this.addressRepository.save(oldAddress);
            return true;
        }

        return false;

    }

    @Override
    public boolean eliminarDireccion(int id) {
        
        address address = new address();

        if(this.addressRepository.findById(id) != null){
            address = this.addressRepository.findById(id).get();
            this.addressRepository.delete(address);
            return true;
        }

        return false;
    }

    @Override
    public List<address> obtenerDireccionesCliente(int id) {
        
        List<address> addresslist = new LinkedList<address>();

        if(this.usersRepository.findById(id) != null){
            
            addresslist = this.usersRepository.findById(id).get().getAddresses();

        }

        return addresslist;
    }
    
}
