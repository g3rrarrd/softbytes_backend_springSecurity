package hn.softbytes.softbytes_backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.softbytes.softbytes_backend.Models.orders;

public interface ordersRepository extends JpaRepository<orders, Integer>{
    
}
