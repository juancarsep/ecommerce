package ar.com.jics.shoppingCart_service.service;

import ar.com.jics.shoppingCart_service.dto.CartItemDTO;
import ar.com.jics.shoppingCart_service.dto.ProductDTO;
import ar.com.jics.shoppingCart_service.model.Cart;
import ar.com.jics.shoppingCart_service.model.CartItem;
import ar.com.jics.shoppingCart_service.repository.ICartRepository;
import ar.com.jics.shoppingCart_service.repository.IProductClientApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements ICartService{

    @Autowired
    ICartRepository repo;
    @Autowired
    IProductClientApi productApi;

    @Override
    public void saveCart(List<CartItemDTO> cartItemsDTO) {

        //Carrito que voy a guardar
        Cart cart = new Cart();

        //Arraylist que le seteo como items a el cart
        List<CartItem> cartItems = new ArrayList<>();


        for(CartItemDTO cartItem : cartItemsDTO){

            //obtengo el producto
            ProductDTO product = productApi.getProduct(cartItem.getProductId());

            CartItem item = new CartItem();
            item.setProductName(product.getName());
            item.setItemsTotal(cartItem.getItemsTotal());
            item.setCartID(cart.getId());
            item.setProductId(product.getId());
            item.setTotalPrice(item.getItemsTotal() * product.getPrice());
            cartItems.add(item);
            item = new CartItem();
        }

        cart.setProductsList(cartItems);
        cart.setTotal(cart.calculateTotal());
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
