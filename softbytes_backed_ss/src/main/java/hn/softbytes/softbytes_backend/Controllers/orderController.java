package hn.softbytes.softbytes_backend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.softbytes.softbytes_backend.Models.orderStatus;
import hn.softbytes.softbytes_backend.Models.orders;
import hn.softbytes.softbytes_backend.Services.Impl.ordersServiceImpl;

@RestController
@RequestMapping("/auth/order")
public class orderController {
    
    @Autowired
    private ordersServiceImpl ordersServiceImpl;

    @GetMapping("/obtener")
    public orders buscarOrden(@RequestParam(name = "idPedido")int idPedido){
        return this.ordersServiceImpl.obtenerPedido(idPedido);
    }

    @GetMapping("/obtener/estado/pedido")
    public orderStatus obtenerEstadoPedido(@RequestParam(name = "idPedido")int idPedido){
        return this.ordersServiceImpl.obtenerEstado(idPedido);
    }

    @DeleteMapping("/eliminar")
    public boolean eliminarPedido(@RequestParam(name = "idPedido")int idPedido){
        return this.ordersServiceImpl.eliminarPedido(idPedido);
    }

    @PostMapping("/crear")
    public boolean crearPedido(@RequestParam(name = "idCliente")int idCliente, @RequestBody orders orders){
        if(this.ordersServiceImpl.crearPedido(idCliente, orders)){
            return true;
        }
        return false;
    }

    @GetMapping("/obtener/pedidos")
    public List<orders> obtenerPedidosClientes(@RequestParam(name = "idCliente")int idCliente){
        return this.ordersServiceImpl.obtenerPedidosCliente(idCliente);    
    }
}
