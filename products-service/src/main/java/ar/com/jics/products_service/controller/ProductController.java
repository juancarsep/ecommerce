package ar.com.jics.products_service.controller;

import ar.com.jics.products_service.model.Product;
import ar.com.jics.products_service.service.IProductsServie;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductsServie service;

    @PostMapping("/")
    public ResponseEntity<String> saveProduct(@RequestBody Product product){
        boolean success = service.saveProduct(product);
        if(success){
            return new ResponseEntity<>("Product successfully saved", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Failed to save product", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = service.getAllProducts();
        if(products != null){
            return new ResponseEntity<>(products, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){

        Product product = service.getProductById(id);

        if(product != null){
            return new ResponseEntity<>(product, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Product>> getProductsByName(@PathVariable String name){

        List<Product> products = service.getProductByName(name);

        if(products != null){
            return new ResponseEntity<>(products, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Product>> getProductsByBrand(@PathVariable String brand){

        List<Product> products = service.getProductByBrand(brand);

        if(products != null){
            return new ResponseEntity<>(products, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id,
                                @RequestBody Product newProduct){
        boolean success = service.updateProduct(id, newProduct);
        if(success){
            return new ResponseEntity<>("Product successfully updated", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Failed to update product", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        boolean success = service.deleteProductById(id);
        if(success){
            return new ResponseEntity<>("Product successfully deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Failed to delete product", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
