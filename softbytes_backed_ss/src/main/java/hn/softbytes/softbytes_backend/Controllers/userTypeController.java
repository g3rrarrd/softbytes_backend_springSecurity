package hn.softbytes.softbytes_backend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.softbytes.softbytes_backend.Models.userType;
import hn.softbytes.softbytes_backend.Services.Impl.userTypeServiceImpl;

@RestController
@RequestMapping("/auth/userType")
public class userTypeController {
    
    @Autowired
    private userTypeServiceImpl userTypeServiceImpl;

    @GetMapping("/obtener")
    public List<userType> obtenerTipos(){
        return this.userTypeServiceImpl.obtenerTiposUsuarios();
    }

}
