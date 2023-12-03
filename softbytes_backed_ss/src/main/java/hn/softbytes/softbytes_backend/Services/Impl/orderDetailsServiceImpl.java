package hn.softbytes.softbytes_backend.Services.Impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.softbytes.softbytes_backend.Models.orderDetail;
import hn.softbytes.softbytes_backend.Models.orders;
import hn.softbytes.softbytes_backend.Models.products;
import hn.softbytes.softbytes_backend.Repositories.orderDetailsRepository;
import hn.softbytes.softbytes_backend.Repositories.ordersRepository;
import hn.softbytes.softbytes_backend.Repositories.productsRepository;
import hn.softbytes.softbytes_backend.Services.orderDetailsService;

@Service
public class orderDetailsServiceImpl implements orderDetailsService{

    @Autowired
    private orderDetailsRepository orderDetailsRepository;
    @Autowired
    private ordersRepository ordersRepository;
    @Autowired
    private productsRepository productsRepository;

   @Override
    public boolean crearOrderDetail(int idPedido, orderDetail orderDetail, int idProducto) {

        orders orders = new orders();
        products products = new products();

        if(this.ordersRepository.findById(idPedido) != null && this.productsRepository.findById(idPedido) != null && orderDetail.getQuantity() > 0){

            products = this.productsRepository.findById(idProducto).get();
            orders = this.ordersRepository.findById(idPedido).get();

            orderDetail.setUnityPrice(products.getUnityPrice());
            orderDetail.setIdOrders(orders);
            orderDetail.setProducts(products);
            this.orderDetailsRepository.save(orderDetail);
            this.ordersRepository.save(orders);
            return true;
        }

        return false;
    }

    @Override
    public List<orderDetail> obtenerDetallesPedido(int id) {
        
        List<orderDetail> orderDetailsList = new LinkedList<orderDetail>();

        if(this.ordersRepository.findById(id) != null){
            for (orderDetail orderDetail : this.orderDetailsRepository.findAll()) {
                if(orderDetail.getIdOrders().getIdOrders() == this.ordersRepository.findById(id).get().getIdOrders()){
                    orderDetailsList.add(orderDetail);
                }
            }
        }

        return orderDetailsList;

    }

    @Override
    public boolean actualizarCantidad(int id, int cantidad) {
       
        orderDetail orderDetail = new orderDetail();
        orders orders = new orders();

        if(this.orderDetailsRepository.findById(id) != null){
            orderDetail = this.orderDetailsRepository.findById(id).get();
            orders = this.ordersRepository.findById(orderDetail.getIdOrders().getIdOrders()).get();
            if(cantidad == 0){
                this.eliminarDetallePedido(id);
                this.ordersRepository.save(orders);
                return false;
            }
            orderDetail.setQuantity(cantidad);
            this.orderDetailsRepository.save(orderDetail);
            this.ordersRepository.save(orders);
            return true;
        }
        return false;

    }

    @Override
    public boolean eliminarDetallePedido(int id) {
        
        orderDetail orderDetail = new orderDetail();
        orders orders = new orders();

        if(this.orderDetailsRepository.findById(id) != null){
            orderDetail = this.orderDetailsRepository.findById(id).get();
            orders = orderDetail.getIdOrders();
            this.orderDetailsRepository.delete(this.orderDetailsRepository.findById(id).get());
            this.ordersRepository.save(orders);
            return true;
        }

        return false;
    }
    
}
