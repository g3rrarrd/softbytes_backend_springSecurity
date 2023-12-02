package hn.softbytes.softbytes_backend.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.softbytes.softbytes_backend.Models.products;

public interface productsRepository extends JpaRepository<products, Integer>{
    List<products> findAllByOrderByUnityPriceAsc();
}
