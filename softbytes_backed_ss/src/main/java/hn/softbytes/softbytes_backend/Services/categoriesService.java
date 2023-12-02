package hn.softbytes.softbytes_backend.Services;

import java.util.List;

import hn.softbytes.softbytes_backend.Models.categories;

public interface categoriesService {
    

    /*
     * Retornara todas las categorias de la base de datos
     * @return Lsit<categories>
     */
    public List<categories> obtenerTodasCategorias();
}
