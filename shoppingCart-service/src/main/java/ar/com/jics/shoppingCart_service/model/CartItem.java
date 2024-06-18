package ar.com.jics.shoppingCart_service.model;

import ar.com.jics.shoppingCart_service.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String productName;
    private Long productId;
    private int itemsTotal;
    private double totalPrice;

}
