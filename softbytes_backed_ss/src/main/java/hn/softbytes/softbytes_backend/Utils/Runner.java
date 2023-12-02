package hn.softbytes.softbytes_backend.Utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import hn.softbytes.softbytes_backend.Models.authority;
import hn.softbytes.softbytes_backend.Models.users;
import hn.softbytes.softbytes_backend.Repositories.authorityRepository;
import hn.softbytes.softbytes_backend.Repositories.usersRepository;

@Component
public class Runner implements CommandLineRunner{

    private final usersRepository usersRepository;

    private final authorityRepository authorityRepository;

    public Runner(usersRepository usersRepository, authorityRepository authorityRepository){
        this.usersRepository = usersRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        if(this.authorityRepository.count() == 0){
            this.authorityRepository.saveAll(List.of(
                new authority(authorityRoles.ROLE_ADMIN),
                new authority(authorityRoles.ROLE_USER)
            ));
        }

        if(this.usersRepository.count() == 0){
            this.usersRepository.saveAll(List.of(
                new users("Gerardo", "Rodriguez", new BCryptPasswordEncoder().encode("1234"), "grod@gmail.com", "grod", List.of(this.authorityRepository.findByName(authorityRoles.ROLE_ADMIN).get())),
                new users("Maria", "Mendez", new BCryptPasswordEncoder().encode("1234"),"mMendez@gmail.com", "mMendez", List.of(this.authorityRepository.findByName(authorityRoles.ROLE_ADMIN).get())),
                new users("Karina", "Perez", new BCryptPasswordEncoder().encode("1234"),"Kperez@gmail.com", "Kperez", List.of(this.authorityRepository.findByName(authorityRoles.ROLE_ADMIN).get()))
            ));
        }

    }



}
