package ar.com.jics.shoppingCart_service.service;

import ar.com.jics.shoppingCart_service.dto.CartItemDTO;
import ar.com.jics.shoppingCart_service.dto.ProductDTO;
import ar.com.jics.shoppingCart_service.model.Cart;

import java.util.List;

public interface ICartService {
    public boolean saveCart(List<CartItemDTO> cartItemsDTO);
    public boolean deleteCart(Long id);
    public boolean updateCart(Long id, Cart cart);
    public Cart getCart(Long id);
    public List<ProductDTO> getCartProducts(Long id);
}
