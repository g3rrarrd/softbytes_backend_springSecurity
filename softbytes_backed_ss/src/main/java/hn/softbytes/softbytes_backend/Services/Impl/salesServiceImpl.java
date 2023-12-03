package hn.softbytes.softbytes_backend.Services.Impl;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.softbytes.softbytes_backend.Models.orderDetail;
import hn.softbytes.softbytes_backend.Models.orders;
import hn.softbytes.softbytes_backend.Models.sales;
import hn.softbytes.softbytes_backend.Repositories.orderDetailsRepository;
import hn.softbytes.softbytes_backend.Repositories.orderStatusRepository;
import hn.softbytes.softbytes_backend.Repositories.ordersRepository;
import hn.softbytes.softbytes_backend.Repositories.salesRepository;
import hn.softbytes.softbytes_backend.Services.salesService;

@Service
public class salesServiceImpl implements salesService{

    @Autowired
    private salesRepository salesRepository;

    @Autowired
    private orderDetailsRepository orderDetailRepository;

    @Autowired
    private ordersRepository ordersRepository;

    @Autowired
    private orderStatusRepository orderStatusRepository;

    @Override
    public boolean crearVenta(int idPedido, sales newSales) {
        
        sales sales = new sales();

        if(this.ordersRepository.findById(idPedido) != null && newSales != null){
           sales.setDate(newSales.getDate());
           sales.setIdOrder(this.ordersRepository.findById(idPedido).get());
           sales.setSubTotal(newSales.getSubTotal());
           sales.setIsv(newSales.getIsv());
           sales.setTotal(newSales.getTotal());
           
           this.salesRepository.save(sales);

           return true;
        }
            return false;
        }

    @Override
    public sales buscarVentaPedido(int id) {
        
        for (sales sales : this.salesRepository.findAll()) {
            if(sales.getIdOrder().getIdOrders() == id){
                return sales;
            }
        }

        return null;
    }

    @Override
    public sales buscarVenta(int id) {

        if(this.salesRepository.findById(id) != null){
            return this.salesRepository.findById(id).get();
        }

        return null;
    }

    @Override
    public List<sales> obtenerVentas()  {
        try{
            
        List<sales> salesList = new LinkedList<sales>();

        if(this.salesRepository.findAll().size() > 0){
            salesList = this.salesRepository.findAll();
        }

        return salesList;
        }catch(Exception e){
            return null;
        }

    }
    
}
