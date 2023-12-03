package hn.softbytes.softbytes_backend.Services.Impl;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.softbytes.softbytes_backend.Models.orderDetail;
import hn.softbytes.softbytes_backend.Models.orderStatus;
import hn.softbytes.softbytes_backend.Models.orders;
import hn.softbytes.softbytes_backend.Models.sales;
import hn.softbytes.softbytes_backend.Models.users;
import hn.softbytes.softbytes_backend.Repositories.orderDetailsRepository;
import hn.softbytes.softbytes_backend.Repositories.orderStatusRepository;
import hn.softbytes.softbytes_backend.Repositories.ordersRepository;
import hn.softbytes.softbytes_backend.Repositories.salesRepository;
import hn.softbytes.softbytes_backend.Repositories.usersRepository;
import hn.softbytes.softbytes_backend.Services.ordersService;

@Service
public class ordersServiceImpl implements ordersService{

    @Autowired
    private ordersRepository ordersRepository;

    @Autowired
    private usersRepository usersRepository;

    @Autowired
    private orderStatusRepository orderStatusRepository;

    @Autowired 
    private orderDetailsRepository orderDetailsRepository;

    @Autowired
    private salesRepository salesRepository;

    @Override
    public orders obtenerPedido(int id) {
        
        if(this.ordersRepository.existsById(id)){
            return this.ordersRepository.findById(id).get();
        }

        return null;
    }

    @Override
    public boolean crearPedido(int idCliente, orders orders) {
    
        
        List<users> users = new LinkedList<users>();

        if( this.usersRepository.findById(idCliente) != null){
            orders.setOrderDate(LocalDate.now());
            orders.setIdOrderStatus(this.orderStatusRepository.findById(1).get());
            users.add(this.usersRepository.findById(idCliente).get());
            orders.setIdUsers(users);
            this.ordersRepository.save(orders);
            return true;
        }

        return false;

    }

    @Override
    public orderStatus obtenerEstado(int id) {
        
        if(this.ordersRepository.existsById(id)){
            return this.ordersRepository.findById(id).get().getIdOrderStatus();
        }
        return null;
    }

    @Override
    public boolean eliminarPedido(int id) {
        
        if(this.ordersRepository.existsById(id)){
            if(this.orderDetailsRepository.findAll().size() > 0){
                for(orderDetail orderDetail : this.orderDetailsRepository.findAll()){
                    if(orderDetail.getIdOrders().getIdOrders() == id){
                        this.orderDetailsRepository.delete(orderDetail);
                    }
                }
            }
            if (this.salesRepository.findAll().size() > 0) {
                for (sales sales : this.salesRepository.findAll()) {
                    if(sales.getIdOrder().getIdOrders() == id){
                        this.salesRepository.delete(sales);
                        break;
                    }
                }
                
            }
            this.ordersRepository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public List<orders> obtenerPedidosCliente(int idCliente) {
        
        if(this.usersRepository.findById(idCliente) != null){
            return this.usersRepository.findById(idCliente).get().getIOrders();
        }

        return null;
    }

    
}
