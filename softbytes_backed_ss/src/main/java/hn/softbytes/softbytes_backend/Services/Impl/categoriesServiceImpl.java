package hn.softbytes.softbytes_backend.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.softbytes.softbytes_backend.Models.categories;
import hn.softbytes.softbytes_backend.Repositories.categoriesRepository;
import hn.softbytes.softbytes_backend.Services.categoriesService;

@Service
public class categoriesServiceImpl implements categoriesService {

    @Autowired
    private categoriesRepository categoriesRepository;

    @Override
    public List<categories> obtenerTodasCategorias() {
        
        if(this.categoriesRepository.findAll().size() > 0){
            return this.categoriesRepository.findAll();
        }

        return null;

    }
    
}
