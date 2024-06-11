package ar.com.jics.shoppingCart_service.controller;

import ar.com.jics.shoppingCart_service.model.Cart;
import ar.com.jics.shoppingCart_service.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    ICartService service;

    @GetMapping("/{id}")
    public Cart getCart(@PathVariable Long id){
        return service.getCart(id);
    }

    @PostMapping("/")
    public String saveCart(@RequestBody Cart cart){
        service.saveCart(cart);
        return "Cart successfully saved";
    }

    @PutMapping("/{id}")
    public String updateCart(@PathVariable Long id,
                             @RequestBody Cart cart){
        service.updateCart(id, cart);
        return "Cart successfully edited";
    }

    @DeleteMapping("/{id}")
    public String deleteCart(@PathVariable Long id){
        service.deleteCart(id);
        return "Cart successfully deleted";
    }

}
