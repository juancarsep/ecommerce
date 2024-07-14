package ar.com.jics.shoppingCart_service.model;

import ar.com.jics.shoppingCart_service.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private double total;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> productsList;

    public double calculateTotal(){

        double total = 0;

        for(CartItem item : productsList){
            total += item.getTotalPrice();
        }

        return total;

    }
}
//Common model para guardar DTOs o entidades para producto e importarlo para no duplicar tanto producto
//Actions de github
//si ocurre una excepcion devuelva un json de excepcion con el codigo de status. Handle Error