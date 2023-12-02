package hn.softbytes.softbytes_backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.softbytes.softbytes_backend.Models.cities;

public interface citiesRepository extends JpaRepository<cities, Integer>{
    
}
