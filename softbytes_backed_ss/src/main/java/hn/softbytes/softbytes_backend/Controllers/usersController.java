package hn.softbytes.softbytes_backend.Controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.softbytes.softbytes_backend.Models.newUserJson;
import hn.softbytes.softbytes_backend.Models.users;
import hn.softbytes.softbytes_backend.Services.Impl.usersServiceImpl;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth/user")
@RequiredArgsConstructor
public class usersController {
    
    @Autowired
    private usersServiceImpl usersServiceImpl;

    @PostMapping("/registrar")
    public boolean registrarCliente(@RequestBody newUserJson newUserJson) {

        if(this.usersServiceImpl.crearCliente(newUserJson)){
            return true;
        }

       return false;
    }

    @PutMapping("/actualizar")
    public String actualizarCliente(@RequestParam(name = "idCliente")int idCliente, @RequestBody users user){
        if(this.usersServiceImpl.modificarCliente(idCliente, user)){
            return "Se ha actualizado el cliente";
        }
        return "No ha podido ser actualizado";
    }    

    @GetMapping("/buscar")
    public users buscarCliente(@RequestParam(name = "idCliente")int idCliente){
        users users = new users();
        users = this.usersServiceImpl.buscarCliente(idCliente);
        return users;
    }

    @GetMapping("/buscar/correo")
    public int buscarClienteCorreo(@RequestParam(name = "email")String email){
        return this.usersServiceImpl.idCliente(email);
    }

    @DeleteMapping("/eliminar")
    public boolean eliminarCliente(@RequestParam(name = "idCliente")int idCliente){
        return this.usersServiceImpl.eliminarCliente(idCliente);
    }

    @GetMapping("/obtener")
    public List<users> obtenerClientes(){
        return this.usersServiceImpl.obtenerTodosClientes();
    }

    @GetMapping("/obtener/tipo")
    public List<users> obtenerTiposClientes(@RequestParam(name = "idTipo")int idTipo){
        return this.usersServiceImpl.obtenerClientePorTipo(idTipo);
    }

    @GetMapping("/obtener/fecha")
    public List<users> obtenerTiposClientes(@RequestParam(name = "fechaInicio")LocalDate fechaInicio, @RequestParam(name = "fechaFinal")LocalDate fechaFinal){
        return this.usersServiceImpl.clientePorFecha(fechaInicio, fechaFinal);
    }

    @GetMapping("/validar")
    public boolean validarCliente(@RequestParam(name = "email")String email, @RequestParam(name = "password")String password){
        return this.usersServiceImpl.isClientValidate(email, password);
    }

}
