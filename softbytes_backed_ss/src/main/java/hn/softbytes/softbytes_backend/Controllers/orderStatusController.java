package hn.softbytes.softbytes_backend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.softbytes.softbytes_backend.Models.orderStatus;
import hn.softbytes.softbytes_backend.Services.Impl.orderStatusServiceImpl;

@RestController
@RequestMapping("auth/orderStatus")
public class orderStatusController {
    
    @Autowired
    private orderStatusServiceImpl orderStatusServiceImpl;

    @GetMapping("/obtener")
    public List<orderStatus> obtenerOrderStatus(){
        return this.orderStatusServiceImpl.obtenerOrdenEstado();
    }    

    @GetMapping("/obtener/status")
    public List<orderStatus> obtenerOrderStatusForStatus(@RequestParam(name = "status")String status){
        return this.orderStatusServiceImpl.obtenerPorEstado(status);
    }

}
