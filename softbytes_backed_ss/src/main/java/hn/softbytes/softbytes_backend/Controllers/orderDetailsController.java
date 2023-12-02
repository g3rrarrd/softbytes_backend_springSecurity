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

import hn.softbytes.softbytes_backend.Models.orderDetail;
import hn.softbytes.softbytes_backend.Services.Impl.orderDetailsServiceImpl;

@RestController
@RequestMapping("/auth/orderDetails")
public class orderDetailsController {
    
    @Autowired
    private orderDetailsServiceImpl orderDetailsServiceImpl;

    @PostMapping("/crear")
    public boolean crearDetallePedido(@RequestParam(name = "idPedido")int idPedido,@RequestBody orderDetail orderDetail,@RequestParam(name = "idProducto") int idProducto){
        
        if(this.orderDetailsServiceImpl.crearOrderDetail(idPedido, orderDetail, idProducto)){
            return true;
        }
        
        return false;

    }

    @GetMapping("/buscar/pedido")
    public List<orderDetail> obtenerDetallesPedido(@RequestParam(name = "idPedido")int idPedido){
        return this.orderDetailsServiceImpl.obtenerDetallesPedido(idPedido);
    }

    @PutMapping("/actualizar")
    public boolean actualizarDetallePedido(@RequestParam(name = "idPedido")int idPedido, @RequestParam(name = "cantidad")int cantidad){
        return this.orderDetailsServiceImpl.actualizarCantidad(idPedido, cantidad);
    }

    @DeleteMapping("/eliminar")
    public boolean eliminarDetallePedido(@RequestParam(name = "idPedido")int idPedido){
        return this.orderDetailsServiceImpl.eliminarDetallePedido(idPedido);
    }

}
