package hn.softbytes.softbytes_backend.Services.Impl;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.softbytes.softbytes_backend.Models.products;
import hn.softbytes.softbytes_backend.Repositories.categoriesRepository;
import hn.softbytes.softbytes_backend.Repositories.productsRepository;
import hn.softbytes.softbytes_backend.Repositories.subCategoriesRepository;
import hn.softbytes.softbytes_backend.Repositories.usersRepository;
import hn.softbytes.softbytes_backend.Services.productsService;

@Service
public class productsServiceImpl implements productsService{

    @Autowired
    private productsRepository productsRepository;
    @Autowired
    private usersRepository usersRepository;
    @Autowired
    private subCategoriesRepository subCategoriesRepository;
    @Autowired
    private categoriesRepository categoriesRepository;

    @Override
    public boolean crearProducto(products products, int idSubCategory, int idCategory) {
       
        if(isValidateProducts(products)){
            products.setPublicationDate(LocalDate.now());
            products.setIdSubCategories(this.subCategoriesRepository.findById(idSubCategory).get());
            products.getIdSubCategories().setCategories(this.categoriesRepository.findById(idCategory).get());
            this.productsRepository.save(products);
            return true;
        }
        return false;
    }

    private boolean isValidateProducts(products products){
        if(!products.getName().equals(null)
        && !products.getPicture().equals(null)
        && !products.getSerialCode().equals(null)
        && !products.getDescription().equals(null)
        && products.getUnityPrice() > 0)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean actualizarProductoPrecio(int id, double price) {
        
        products products;

        if (price > 0 && this.productsRepository.findById(id) != null) {
            products = this.productsRepository.findById(id).get();
            products.setUnityPrice(price);
            this.productsRepository.save(products);
            return true;
        }

        return false;
    }

    @Override
    public boolean eliminarProducto(int id) {
        
        if(this.productsRepository.existsById(id)){
            this.productsRepository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public products obtenerProducto(int id) {
       
        if (this.productsRepository.existsById(id)) {
            return this.productsRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public List<products> obtenerTodosProductos() {
        
        return this.productsRepository.findAll();

    }

    @Override
    public List<products> ordenarPrecio(double price) {
        
        return this.productsRepository.findAllByOrderByUnityPriceAsc();

    }

    @Override
    public List<products> obtenerProductosSubCategoria(String subcategoria) {
       
        List<products> productsList = new LinkedList<products>();

        for (products products : this.productsRepository.findAll()) {
            if(products.getIdSubCategories().getDescription().equals(subcategoria)){
                productsList.add(products);
            }
        }

        return productsList;
    }

    @Override
    public List<products> obtenerProductosCategoria(String categoria) {

       List<products> productsList = new LinkedList<products>();

        for (products products : this.productsRepository.findAll()) {
            if(products.getIdSubCategories().getCategories().getDescription().equals(categoria)){
                productsList.add(products);
            }
        }

        return productsList;
    }

    @Override
    public boolean actualizarProdcutoReviews(int id, String review) {
        products products = new products();
            if(this.productsRepository.findById(id) != null){
                products = this.productsRepository.findById(id).get();
                products.setReviews(review);
                this.productsRepository.save(products);
                return true;
            }
        return false;
    }


}
