package ar.com.jics.products_service.service;

import ar.com.jics.products_service.model.Product;

import java.util.List;

public interface IProductsServie {
    public boolean saveProduct(Product prod);
    public Product getProductById(Long id);
    public List<Product> getAllProducts();
    public boolean updateProduct(Long id, Product prod);
    public boolean deleteProductById(Long id);
    public List<Product> getProductByName(String name);
    public List<Product> getProductByBrand(String brand);
}
