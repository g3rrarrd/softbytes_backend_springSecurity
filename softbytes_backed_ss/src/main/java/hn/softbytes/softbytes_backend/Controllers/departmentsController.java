package hn.softbytes.softbytes_backend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.softbytes.softbytes_backend.Models.departments;
import hn.softbytes.softbytes_backend.Services.Impl.departmentsServiceImpl;

@RestController
@RequestMapping("/auth/departamento")
public class departmentsController {

    @Autowired
    private departmentsServiceImpl departmentsServiceImpl;

    @GetMapping("/obtener")
    public List<departments> obtenerDepartamentos(){
        return this.departmentsServiceImpl.obtenerTodosDepartamentos();
    }
    
}
