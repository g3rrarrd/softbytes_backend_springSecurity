package hn.softbytes.softbytes_backend.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.softbytes.softbytes_backend.Models.countries;
import hn.softbytes.softbytes_backend.Repositories.countriesRepository;
import hn.softbytes.softbytes_backend.Services.countriesService;

@Service
public class countriesServiceImpl implements countriesService{

    @Autowired
    private countriesRepository countriesRepository;

    @Override
    public List<countries> obtenerTodosPaises() {
        
        if(this.countriesRepository.findAll().size() > 0){
            return this.countriesRepository.findAll();
        }

        return null;
    }
    
}
