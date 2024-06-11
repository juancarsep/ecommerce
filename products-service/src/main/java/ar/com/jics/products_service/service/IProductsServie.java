package ar.com.jics.products_service.service;

import ar.com.jics.products_service.model.Product;

import java.util.List;

public interface IProductsServie {
    public void saveProduct(Product prod);
    public Product getProductById(Long id);
    public List<Product> getAllProducts();
    public void updateProduct(Long id, Product prod);
    public void deleteProductById(Long id);
    public void getProductByName(String name);
    public void getProductByBrand(String brand);
}
