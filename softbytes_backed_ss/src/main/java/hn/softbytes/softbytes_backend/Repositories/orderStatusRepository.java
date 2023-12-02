package hn.softbytes.softbytes_backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.softbytes.softbytes_backend.Models.orderStatus;

public interface orderStatusRepository extends JpaRepository<orderStatus, Integer>{
    
}
