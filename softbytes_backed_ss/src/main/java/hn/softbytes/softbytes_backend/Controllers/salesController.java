package hn.softbytes.softbytes_backend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.softbytes.softbytes_backend.Models.sales;
import hn.softbytes.softbytes_backend.Services.Impl.salesServiceImpl;

@RestController
@RequestMapping("/auth/sales")
public class salesController {
    
    @Autowired
    private salesServiceImpl salesServiceImpl;

    @PostMapping("/crear")
    public boolean crearVenta(@RequestParam(name = "idPedido")int idPedido){
        if(this.salesServiceImpl.crearVenta(idPedido)){
            return true;
        }
        return false;
    }

    @GetMapping("/buscar/pedido")
    public sales buscarVentaPedido(@RequestParam(name = "idPedido")int idPedido){
        return this.salesServiceImpl.buscarVentaPedido(idPedido);
    }

    @GetMapping("/buscar")
    public sales buscarVenta(@RequestParam(name = "idVenta")int idVenta){
        return this.salesServiceImpl.buscarVenta(idVenta);
    }

    @GetMapping("/obtener")
    public List<sales> obtenerVenta(){
        return this.salesServiceImpl.obtenerVentas();
    }

}
