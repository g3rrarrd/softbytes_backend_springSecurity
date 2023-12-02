package hn.softbytes.softbytes_backend.Services.Impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.softbytes.softbytes_backend.Models.subCategories;
import hn.softbytes.softbytes_backend.Repositories.subCategoriesRepository;
import hn.softbytes.softbytes_backend.Services.subCategoriesService;

@Service
public class subCategoriesServiceImpl implements subCategoriesService{

    @Autowired
    private subCategoriesRepository subCategoriesRepository;

    @Override
    public List<subCategories> obtenerSubCategories() {
       
        List<subCategories> subCategoriesList = new LinkedList<subCategories>();

        for (subCategories subCategory : this.subCategoriesRepository.findAll()) {
            subCategoriesList.add(subCategory);
        }

        return subCategoriesList;
    }

    @Override
    public List<subCategories> obtenerSubCategoriesCategoria(String categoria) {
        
        List<subCategories> subCategoriesList = new LinkedList<subCategories>();

        for (subCategories subCategory : this.subCategoriesRepository.findAll()) {
            
            if(subCategory.getCategories().getDescription().equals(categoria)){
                subCategoriesList.add(subCategory);
            }

        }

        return subCategoriesList;

    }
    
}
