package hn.softbytes.softbytes_backend.Controllers;

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

import hn.softbytes.softbytes_backend.Models.address;
import hn.softbytes.softbytes_backend.Services.Impl.addressServiceImpl;

@RestController
@RequestMapping("/auth/direccion")
public class addressController {

    @Autowired
    private addressServiceImpl addressServiceImpl;

    @PostMapping("/crear")
    public boolean crearDireccion(@RequestParam(name = "idCliente")int idCliente,@RequestParam(name = "idCiudad")int idCiudad, @RequestBody address address){
        return this.addressServiceImpl.crearDireccion(idCliente, idCiudad, address);
    }

    @GetMapping("/buscar")
    public address buscarDireccion(@RequestParam(name = "idDireccion")int idDireccion){
        return this.addressServiceImpl.buscarDireccion(idDireccion);
    }

    @GetMapping("/obtener")
    public List<address> obtenerDirecciones(){
        return this.addressServiceImpl.obtenerDireciones();
    }

    @PutMapping("/actualizar")
    public boolean actualizarDireccion(@RequestParam(name = "idDireccion")int idDireccion, @RequestBody address address ){
        return this.addressServiceImpl.actualizarDireccion(idDireccion, address);
    }
    
    @DeleteMapping("/eliminar")
    public boolean eliminarDireccion(@RequestParam(name = "idDireccion")int idDireccion){
        return this.addressServiceImpl.eliminarDireccion(idDireccion);
    }

    @GetMapping("/obtener/direccion/cliente")
    public List<address> obtenerDireccionCliente(@RequestParam(name = "idCliente")int idCliente){
        return this.addressServiceImpl.obtenerDireccionesCliente(idCliente);
    }
}
