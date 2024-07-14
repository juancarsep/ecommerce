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
    public boolean saveCart(List<CartItemDTO> cartItemsDTO) {

        try{
            //Carrito que voy a guardar
            Cart cart = new Cart();

            //liberia que permita no usar el new para crear listas
            List<CartItem> cartItems = new ArrayList<>();

            //usar funciones lambda
            for(CartItemDTO cartItem : cartItemsDTO){

                //obtengo el producto
                ProductDTO product = productApi.getProduct(cartItem.getProductId());

                CartItem item = new CartItem();

                // !!! CartItem.builder().productName(product.getName()).itemsTotal(product.getName()).build(); !!! crear en una sola nueva linea sin new.  !!!
                item.setProductName(product.getName());
                item.setItemsTotal(cartItem.getItemsTotal());
                item.setProductId(product.getId());
                item.setTotalPrice(item.getItemsTotal() * product.getPrice());

                cartItems.add(item);

                item = new CartItem();
            }
            cart.setProductsList(cartItems);
            cart.setTotal(cart.calculateTotal());
            repo.save(cart);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public Cart getCart(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<ProductDTO> getCartProducts(Long id) {

        List<ProductDTO> products = new ArrayList<>();

        Cart cart = this.getCart(id);

        if(cart != null){

            List<CartItem> cartItems = cart.getProductsList();

            for(CartItem item : cartItems){

                ProductDTO product = new ProductDTO();
                product = productApi.getProduct(item.getProductId());
                products.add(product);

            }
        }else{
            System.out.println("Error, Cart with ID: " + id +  " does not exist");
        }


        return products;
    }

    @Override
    public boolean updateCart(Long id, Cart newCart) {
        Cart cart = this.getCart(id);
        if(cart != null){
            cart.setTotal(newCart.getTotal());
            cart.setProductsList(newCart.getProductsList());
            repo.save(cart);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteCart(Long id) {
        try{
            repo.deleteById(id);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
