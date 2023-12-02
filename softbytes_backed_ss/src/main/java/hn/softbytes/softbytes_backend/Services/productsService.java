package hn.softbytes.softbytes_backend.Services;

import java.util.List;

import hn.softbytes.softbytes_backend.Models.products;
import hn.softbytes.softbytes_backend.Models.subCategories;

public interface productsService {

    /*
     * Crea un producto en la base de datos
     * @param product:Json
     * @return boolean
     */
    public boolean crearProducto(products products, int idSubCategory, int idCategory);

    /*
     * Actualiza el precio de un producto
     * @param id idProducto
     * @param price double
     * @return boolean
     */
    public boolean actualizarProductoPrecio(int id, double price);

    /*
     * Elimina un prodcuto por id
     * @param id idProducto
     * @param boolean
     */
    public boolean eliminarProducto(int id);

    /*
     * Obtiene el producto
     * @param id idProdcuto
     * @return products
     */
    public products obtenerProducto(int id);

    /*
     * Obtiene todos los productos disponible
     * @return lista<Prodcutos>
     */
    public List<products> obtenerTodosProductos();

    /*
     * Ordena los productos menores al precio
     * @param price double
     * @return List<products>
     */
    public List<products> ordenarPrecio(double price);    

    /*
     * Retorna una lista de productos segun su subcategoria
     * @param subcategoria String
     * @return List<products>
     */
    public List<products> obtenerProductosSubCategoria(String subcategoria);

    /*
     * Retorna una lista de productos segun su categoria
     * @param categoria String
     * @return List<products>
     */
    public List<products> obtenerProductosCategoria(String categoria);

    public boolean actualizarProdcutoReviews(int id, String review);
}
