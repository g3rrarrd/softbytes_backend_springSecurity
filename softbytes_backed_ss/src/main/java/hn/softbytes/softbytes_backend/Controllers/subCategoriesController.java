package hn.softbytes.softbytes_backend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.softbytes.softbytes_backend.Models.subCategories;
import hn.softbytes.softbytes_backend.Services.Impl.subCategoriesServiceImpl;

@RestController
@RequestMapping("/auth/subCategories")
public class subCategoriesController {
    
    @Autowired
    private subCategoriesServiceImpl subCategoriesServiceImpl;

    @GetMapping("/obtener")
    public List<subCategories> obtenerSubCategories(){
        return this.subCategoriesServiceImpl.obtenerSubCategories();
    }

    @GetMapping("obtener/subCategories/categories")
    public List<subCategories> obtenerSubCategoriesCategories(@RequestParam(name = "categoria")String categoria){
        return this.subCategoriesServiceImpl.obtenerSubCategoriesCategoria(categoria);
    }

}
