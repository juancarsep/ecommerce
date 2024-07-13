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
            return ResponseEntity.status(HttpStatus.CREATED).body("Product successfully saved");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to save product");
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = service.getAllProducts();
        if(products != null){
            return ResponseEntity.ok(products);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){

        Product product = service.getProductById(id);

        if(product != null){
            return  ResponseEntity.ok(product);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Product>> getProductsByName(@PathVariable String name){

        List<Product> products = service.getProductByName(name);

        if(products != null){
            return ResponseEntity.status(HttpStatus.OK).body(products);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Product>> getProductsByBrand(@PathVariable String brand){

        List<Product> products = service.getProductByBrand(brand);

        if(products != null){
            return ResponseEntity.status(HttpStatus.OK).body(products);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id,
                                @RequestBody Product newProduct){
        boolean success = service.updateProduct(id, newProduct);
        if(success){
            return ResponseEntity.status(HttpStatus.OK).body("Product successfully updated");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update product");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        boolean success = service.deleteProductById(id);
        if(success){
            return ResponseEntity.status(HttpStatus.OK).body("Product successfully deleted");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete product");
        }
    }


}
