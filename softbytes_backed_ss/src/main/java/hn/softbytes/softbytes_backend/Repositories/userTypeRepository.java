package hn.softbytes.softbytes_backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.softbytes.softbytes_backend.Models.userType;

public interface userTypeRepository extends JpaRepository<userType, Integer>{
    
}
