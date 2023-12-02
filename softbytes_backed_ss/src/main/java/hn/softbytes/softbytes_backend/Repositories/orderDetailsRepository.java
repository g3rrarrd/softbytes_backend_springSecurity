package hn.softbytes.softbytes_backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.softbytes.softbytes_backend.Models.orderDetail;

public interface orderDetailsRepository extends JpaRepository<orderDetail, Integer>{
    
}
