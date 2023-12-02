package hn.softbytes.softbytes_backend.Services;

import java.util.List;

import hn.softbytes.softbytes_backend.Models.orderDetail;

public interface orderDetailsService {
    
    /*
     * Creara un valor en la tabla detalle pedido
     * @param orderDetail orderDetail:Json
     * @return boolean
     */
    public boolean crearOrderDetail(int idPedido, orderDetail orderDetail, int idProducto);

    /*
     * obtendra los detalles de los pedidos de un pedido
     * @param id idPedido
     * @return List<orderDetail>
     */
    public List<orderDetail> obtenerDetallesPedido(int id);

    /*
     * Actualizara el valor cantidad de la tabla detallePedido
     * @param id idOrderDetail
     * @param cantidad Nueva Cantidad
     * @return boolean
     */
    public boolean actualizarCantidad(int id, int cantidad);

    public boolean eliminarDetallePedido(int id);
}

