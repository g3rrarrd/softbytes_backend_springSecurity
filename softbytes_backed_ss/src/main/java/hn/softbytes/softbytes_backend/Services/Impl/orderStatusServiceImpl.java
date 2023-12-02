package hn.softbytes.softbytes_backend.Services.Impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.softbytes.softbytes_backend.Models.orderStatus;
import hn.softbytes.softbytes_backend.Repositories.orderStatusRepository;
import hn.softbytes.softbytes_backend.Services.orderStatusService;

@Service
public class orderStatusServiceImpl implements orderStatusService{

    @Autowired
    private orderStatusRepository orderStatusRepository;

    @Override
    public List<orderStatus> obtenerOrdenEstado() {
        
        return this.orderStatusRepository.findAll(); 

    }

    @Override
    public List<orderStatus> obtenerPorEstado(String estado) {
       
        List<orderStatus> orderStatusList = new LinkedList<orderStatus>();

        for (orderStatus orderStatus : this.orderStatusRepository.findAll()) {
            if(orderStatus.getDescription().equals(estado)){
                orderStatusList.add(orderStatus);
            }
        }

        return orderStatusList;
    }
    
}
