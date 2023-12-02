package hn.softbytes.softbytes_backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hn.softbytes.softbytes_backend.Models.users;
import hn.softbytes.softbytes_backend.Repositories.usersRepository;
import hn.softbytes.softbytes_backend.Security.securityUser;

@Service
public class userDetailsService implements UserDetailsService {
    
    @Autowired
    private usersRepository usersRepository;

    public userDetailsService(usersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        var optUser = this.usersRepository.findByUsername(username);
        
        if(optUser.isPresent()){
            return new securityUser(optUser.get());
        }

        throw new UsernameNotFoundException(username);

    }



}
