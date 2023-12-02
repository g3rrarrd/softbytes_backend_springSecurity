package hn.softbytes.softbytes_backend.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.softbytes.softbytes_backend.Models.cities;
import hn.softbytes.softbytes_backend.Models.countries;
import hn.softbytes.softbytes_backend.Models.departments;
import hn.softbytes.softbytes_backend.Repositories.citiesRepository;
import hn.softbytes.softbytes_backend.Services.citiesService;

@Service
public class citiesServiceImpl implements citiesService{

    @Autowired
    private citiesRepository citiesRepository;

    @Override
    public List<cities> obtenerCiudades() {
        
        if(this.citiesRepository.findAll().size() > 0){
            return this.citiesRepository.findAll();
        }

        return null;
    }

   
    
}
