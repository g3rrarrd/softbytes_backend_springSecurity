package hn.softbytes.softbytes_backend.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.softbytes.softbytes_backend.Models.departments;
import hn.softbytes.softbytes_backend.Repositories.departmentsRepository;
import hn.softbytes.softbytes_backend.Services.departmentsService;

@Service
public class departmentsServiceImpl implements departmentsService{


    @Autowired
    private departmentsRepository departmentsRepository;

    @Override
    public List<departments> obtenerTodosDepartamentos() {

        if(this.departmentsRepository.findAll().size() > 0){
            return this.departmentsRepository.findAll();
        }

        return null;
    }

    
}
