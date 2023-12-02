package hn.softbytes.softbytes_backend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.softbytes.softbytes_backend.Models.countries;
import hn.softbytes.softbytes_backend.Services.Impl.countriesServiceImpl;

@RestController
@RequestMapping("/auth/pais")
public class countriesController {
    
    @Autowired
    private countriesServiceImpl countriesServiceImpl;

    @GetMapping("/obtener")
    public List<countries> obtenerPaises(){
        return this.countriesServiceImpl.obtenerTodosPaises();
    }

}
