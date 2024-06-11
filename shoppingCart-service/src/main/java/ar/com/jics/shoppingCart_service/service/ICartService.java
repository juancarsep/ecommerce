package ar.com.jics.shoppingCart_service.service;

import ar.com.jics.shoppingCart_service.model.Cart;

import java.util.List;

public interface ICartService {
    public void saveCart(Cart cart);
    public void deleteCart(Long id);
    public void updateCart(Long id, Cart cart);
    public Cart getCart(Long id);
}
