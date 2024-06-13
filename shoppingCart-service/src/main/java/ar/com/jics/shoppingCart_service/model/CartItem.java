package ar.com.jics.shoppingCart_service.model;

import ar.com.jics.shoppingCart_service.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String productName;
    private Long productId;
    private int itemsTotal;
    private double totalPrice;


  /*
    public void addItem(){
        this.itemsTotal += 1;
        updatePrice();
    }

    public void removeItem(){
        this.itemsTotal -= 1;
        updatePrice();
    }

    public void updatePrice(){
        this.totalPrice = itemsTotal * product.getPrice();
    }
    */
}
