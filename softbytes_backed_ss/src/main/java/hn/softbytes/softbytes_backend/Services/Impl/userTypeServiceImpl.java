package hn.softbytes.softbytes_backend.Services.Impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.softbytes.softbytes_backend.Models.userType;
import hn.softbytes.softbytes_backend.Repositories.userTypeRepository;
import hn.softbytes.softbytes_backend.Services.userTypeService;

@Service
public class userTypeServiceImpl implements userTypeService{

    @Autowired
    private userTypeRepository userTypeRepository;

    @Override
    public List<userType> obtenerTiposUsuarios() {
        List<userType> userTypes = new LinkedList<userType>();
        for (userType userType : this.userTypeRepository.findAll()) {
            userTypes.add(userType);
        }
        return userTypes;
    }
    
}
