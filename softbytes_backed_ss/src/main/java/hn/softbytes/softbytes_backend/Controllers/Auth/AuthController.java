package hn.softbytes.softbytes_backend.Controllers.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.softbytes.softbytes_backend.Models.users;
import hn.softbytes.softbytes_backend.Services.Impl.usersServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    
    @GetMapping("/login")
    public String login()
    {
        return "Login from public endpoint";
    }

    @PostMapping(value = "registr")
    public String register()
    {
        return "Register from public endpoint";
    }

}
