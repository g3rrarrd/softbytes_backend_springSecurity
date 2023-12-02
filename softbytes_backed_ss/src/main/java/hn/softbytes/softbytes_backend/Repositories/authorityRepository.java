package hn.softbytes.softbytes_backend.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.softbytes.softbytes_backend.Models.authority;
import hn.softbytes.softbytes_backend.Utils.authorityRoles;

import java.util.List;


public interface authorityRepository extends JpaRepository<authority, Integer>{
    
    Optional<authority>findByName(authorityRoles name);

}
