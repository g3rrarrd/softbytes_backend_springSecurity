package hn.softbytes.softbytes_backend.Services;

import java.util.List;

import hn.softbytes.softbytes_backend.Models.orderStatus;
import hn.softbytes.softbytes_backend.Models.orders;

public interface ordersService {
    
    /*
     * Obtendra el pedido por medio de una id
     * @param id idPedido
     * @return orders
     */
    public orders obtenerPedido(int id);

    /*
     * Creara un pedido en la base de datos
     * @param orders orders:Json
     * @return boolean
     */
    public int crearPedido(int idCliente, orders orders);

    /*
     * Obtendra el estado del pedido buscado por la id
     * @param id idPedido
     * @return orderStatus
     */
    public orderStatus obtenerEstado(int id);

    public boolean eliminarPedido(int id);

    public List<orders> obtenerPedidosCliente(int idCliente);

}
