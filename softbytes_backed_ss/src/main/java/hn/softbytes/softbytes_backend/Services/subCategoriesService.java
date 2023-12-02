package hn.softbytes.softbytes_backend.Services;

import java.util.List;

import hn.softbytes.softbytes_backend.Models.subCategories;

public interface subCategoriesService {
    
    /*
     * Obtiene todas las cub categorias disponible en el comercio
     * @return List<subCategories>
     */
    public List<subCategories> obtenerSubCategories();
    
    /*
     * Obtiene todas las sub categorias disponible de la categoria
     * @param categoria String
     * @return List<subCategories>
     */
    public List<subCategories> obtenerSubCategoriesCategoria(String categoria);
}
