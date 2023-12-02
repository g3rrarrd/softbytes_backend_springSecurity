package hn.softbytes.softbytes_backend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.softbytes.softbytes_backend.Models.cities;
import hn.softbytes.softbytes_backend.Services.Impl.citiesServiceImpl;

@RestController
@RequestMapping("/auth/ciudad")
public class citiesController {

    @Autowired
    private citiesServiceImpl citiesServiceImpl;

    @GetMapping("/obtener")
    public List<cities> obtenerCiudades(){
        return this.citiesServiceImpl.obtenerCiudades();
    }
    
}
