package hn.softbytes.softbytes_backend.Services;

import java.util.List;

import hn.softbytes.softbytes_backend.Models.departments;

public interface departmentsService {
    

    /*
     * Obtendra todos los departamentos en la tabla de dato
     * @return List<departaments>
     */
    public List<departments> obtenerTodosDepartamentos();

}
