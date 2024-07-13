package ar.com.jics.products_service.service;

import ar.com.jics.products_service.model.Product;
import ar.com.jics.products_service.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements IProductsServie{

    @Autowired
    IProductRepository repo;

    @Override
    public boolean saveProduct(Product prod) {
        try{
            repo.save(prod);
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    @Override
    public Product getProductById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    @Override
    public boolean updateProduct(Long id, Product prod) {
        Product product = this.getProductById(id);
        if(product != null){
            product.setName(prod.getName());
            product.setBrand(prod.getBrand());
            product.setPrice(prod.getPrice());
            repo.save(product);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteProductById(Long id) {
        try{
            repo.deleteById(id);
            return true;
        }catch(Exception ex){
            return false;
        }

    }

    @Override
    public List<Product> getProductByName(String name) {
        return repo.getProductsByName(name);
    }

    @Override
    public List<Product> getProductByBrand(String brand) {
        return repo.getProductsByBrand(brand);
    }
}
