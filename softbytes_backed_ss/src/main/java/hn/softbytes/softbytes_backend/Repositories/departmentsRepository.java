package hn.softbytes.softbytes_backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.softbytes.softbytes_backend.Models.departments;

public interface departmentsRepository extends JpaRepository<departments, Integer>{
    
}
