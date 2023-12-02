package hn.softbytes.softbytes_backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.softbytes.softbytes_backend.Models.products;
import hn.softbytes.softbytes_backend.Services.Impl.ordersServiceImpl;
import hn.softbytes.softbytes_backend.Services.Impl.productsServiceImpl;

@RestController
@RequestMapping("v1/")
public class apisNoAuthController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("/hello")
    public String hello2(){
        return "hello admins from post";
    }
    
}
