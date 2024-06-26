package ar.com.jics.sales_service.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ProductDTO {
    private Long id;
    private String name;
    private String brand;
    private double price;
}
