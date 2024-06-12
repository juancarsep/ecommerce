package ar.com.jics.shoppingCart_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CartItemDTO {

    private Long productId;
    private int itemsTotal;

}
