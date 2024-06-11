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
    public void saveProduct(Product prod) {
        repo.save(prod);
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
    public void updateProduct(Long id, Product prod) {
        Product product = this.getProductById(id);
        if(product != null){
            product.setName(prod.getName());
            product.setBrand(prod.getBrand());
            product.setPrice(prod.getPrice());
            repo.save(product);
        }else{
            System.out.println("An error has occurred: Product with ID " + id + " Does not exist");
        }
    }

    @Override
    public void deleteProductById(Long id) {
        repo.deleteById(id);
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
