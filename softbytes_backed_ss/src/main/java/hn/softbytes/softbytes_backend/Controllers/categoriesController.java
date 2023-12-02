package hn.softbytes.softbytes_backend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.softbytes.softbytes_backend.Models.categories;
import hn.softbytes.softbytes_backend.Services.Impl.categoriesServiceImpl;

@RestController
@RequestMapping("/auth/categoria")
public class categoriesController {

    @Autowired
    private categoriesServiceImpl categoriesServiceImpl;

    @GetMapping("/obtener")
    public List<categories> obtenerCategorias(){
        return this.categoriesServiceImpl.obtenerTodasCategorias();
    }
    
}
