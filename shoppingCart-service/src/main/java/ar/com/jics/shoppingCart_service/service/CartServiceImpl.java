package ar.com.jics.shoppingCart_service.service;

import ar.com.jics.shoppingCart_service.model.Cart;
import ar.com.jics.shoppingCart_service.repository.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements ICartService{

    @Autowired
    ICartRepository repo;

    @Override
    public void saveCart(Cart cart) {
        repo.save(cart);
    }

    @Override
    public Cart getCart(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void updateCart(Long id, Cart newCart) {
        Cart cart = this.getCart(id);
        if(cart != null){
            cart.setTotal(newCart.getTotal());
            cart.setProductsList(newCart.getProductsList());
            repo.save(cart);
        }else{
            System.out.println("Error, Cart with ID: " + id + " does not exist");
        }
    }

    @Override
    public void deleteCart(Long id) {
        repo.deleteById(id);
    }


}
