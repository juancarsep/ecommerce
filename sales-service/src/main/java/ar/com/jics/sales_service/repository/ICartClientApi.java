package ar.com.jics.sales_service.repository;

import ar.com.jics.sales_service.dto.CartDTO;
import ar.com.jics.sales_service.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name ="cart-service")
public interface ICartClientApi {

    @GetMapping("/cart/{id}")
    public CartDTO getCartById(@PathVariable ("id") Long id);

    @GetMapping("/cart/products/{id}")
    public List<ProductDTO> getCartProducts(@PathVariable Long id);

}
