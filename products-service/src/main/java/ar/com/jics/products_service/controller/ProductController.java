package ar.com.jics.products_service.controller;

import ar.com.jics.products_service.model.Product;
import ar.com.jics.products_service.service.IProductsServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductsServie service;

    @PostMapping("/")
    public String saveProduct(@RequestBody Product product){
        service.saveProduct(product);
        return "Product successfully saved";
    }

    @GetMapping("/")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return service.getProductById(id);
    }

    @GetMapping("/name/{name}")
    public List<Product> getProductsByName(@PathVariable String name){
        return service.getProductByName(name);
    }

    @GetMapping("/brand/{brand}")
    public List<Product> getProductsByBrand(@PathVariable String brand){
        return service.getProductByBrand(brand);
    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable Long id,
                                @RequestBody Product newProduct){
        service.updateProduct(id, newProduct);
        return "Product successfully updated";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        service.deleteProductById(id);
        return "Product succesfully deleted";
    }


}
