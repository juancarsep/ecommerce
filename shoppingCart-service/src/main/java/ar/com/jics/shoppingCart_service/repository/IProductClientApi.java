package ar.com.jics.shoppingCart_service.repository;

import ar.com.jics.shoppingCart_service.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "products-service")
public interface IProductClientApi {

    @GetMapping("/products/{id}")
    public ProductDTO getProduct(@PathVariable ("id") Long id);


}
