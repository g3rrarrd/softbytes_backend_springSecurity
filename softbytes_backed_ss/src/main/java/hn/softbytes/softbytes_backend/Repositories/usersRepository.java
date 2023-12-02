package hn.softbytes.softbytes_backend.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.softbytes.softbytes_backend.Models.users;
import java.util.List;


public interface usersRepository extends JpaRepository<users, Integer>{
    
    Optional<users>findByUsername(String username);

}
