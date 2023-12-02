package hn.softbytes.softbytes_backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.softbytes.softbytes_backend.Models.categories;

public interface categoriesRepository extends JpaRepository<categories, Integer>{
    
}
