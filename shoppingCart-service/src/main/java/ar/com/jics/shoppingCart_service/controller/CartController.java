package ar.com.jics.shoppingCart_service.controller;

import ar.com.jics.shoppingCart_service.dto.CartItemDTO;
import ar.com.jics.shoppingCart_service.dto.ProductDTO;
import ar.com.jics.shoppingCart_service.model.Cart;
import ar.com.jics.shoppingCart_service.service.ICartService;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    ICartService service;

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCart(@PathVariable Long id){
        Cart cart = service.getCart(id);
        if(cart != null && cart.getId() == id){
            return ResponseEntity.ok(cart);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<String> saveCart(@RequestBody List<CartItemDTO> items){
        boolean success = service.saveCart(items);
        if(success){
            return ResponseEntity.ok("Cart successfully created");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create cart");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCart(@PathVariable Long id,
                             @RequestBody Cart cart){
        boolean success = service.updateCart(id, cart);

        if(success){
            return ResponseEntity.ok("Cart successfully updated");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update cart");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCart(@PathVariable Long id){
        boolean success = service.deleteCart(id);
        if(success){
            return ResponseEntity.ok("Cart successfully deleted");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete cart");
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<List<ProductDTO>> getCartProducts(@PathVariable Long id){

        List<ProductDTO> products = service.getCartProducts(id);

        if(products != null && !products.isEmpty()){
            return ResponseEntity.ok(products);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
