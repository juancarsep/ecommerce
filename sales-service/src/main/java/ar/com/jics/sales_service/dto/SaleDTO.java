package ar.com.jics.sales_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class SaleDTO {
    private Long id;
    private LocalDate date;
    private Long cartId;
    private double total;
    private List<ProductDTO> products;
}
