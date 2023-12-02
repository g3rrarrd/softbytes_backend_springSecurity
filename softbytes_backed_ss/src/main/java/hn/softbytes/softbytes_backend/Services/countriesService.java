package hn.softbytes.softbytes_backend.Services;

import java.util.List;

import hn.softbytes.softbytes_backend.Models.countries;

public interface countriesService {
    
    /*
     * Retornara todos los paises de la base de datos
     * @return List<countries>
     */
    public List<countries> obtenerTodosPaises();

}
