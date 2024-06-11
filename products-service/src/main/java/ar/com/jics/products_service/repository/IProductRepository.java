package ar.com.jics.products_service.repository;

import ar.com.jics.products_service.model.Product;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.xml.namespace.QName;
import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.name = :name")
    public List<Product> getProductsByName(@Param("name") String name);

    @Query("SELECT p FROM Product p WHERE p.brand = :brand")
    public List<Product> getProductsByBrand(@Param("brand") String brand);

}
