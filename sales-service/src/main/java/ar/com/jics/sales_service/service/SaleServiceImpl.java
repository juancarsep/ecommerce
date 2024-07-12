package ar.com.jics.sales_service.service;

import ar.com.jics.sales_service.dto.CartDTO;
import ar.com.jics.sales_service.dto.ProductDTO;
import ar.com.jics.sales_service.dto.SaleDTO;
import ar.com.jics.sales_service.model.Sale;
import ar.com.jics.sales_service.repository.ICartClientApi;
import ar.com.jics.sales_service.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleServiceImpl implements ISaleService{

    @Autowired
    ISaleRepository repo;
    @Autowired
    ICartClientApi cartApi;

    @Override
    public boolean saveSale(Sale sale) {
        try{
            repo.save(sale);
            return true;
        }catch(Exception ex){
            return false;
        }

    }

    @Override
    public Sale getSale(Long id){
        return repo.findById(id).orElse(null);
    }



    @Override
    public List<Sale> getAllSales() {
        return repo.findAll();
    }

    @Override
    public boolean updateSale(Long id, Sale newSale) {
        Sale sale = this.getSale(id);
        if(sale!=null) {
            sale.setDate(newSale.getDate());
            sale.setCartId(newSale.getCartId());
            repo.save(sale);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteSale(Long id) {
        try{
            repo.deleteById(id);
            return true;
        }catch(Exception ex){
            return false;
        }
    }


    private List<ProductDTO> getSaleProducts(Long id) {
        Sale sale = this.getSale(id);
        List<ProductDTO> products = new ArrayList<>();
        if(sale != null){
            products = cartApi.getCartProducts(id);
        }

        return products;
    }


    @Override
    public SaleDTO getDetailedSale(Long id) {
        Sale sale = this.getSale(id);
        SaleDTO saleDto = new SaleDTO();
        if(sale != null){
            saleDto = new SaleDTO();
            saleDto.setId(sale.getId());
            saleDto.setDate(sale.getDate());
            saleDto.setProducts(this.getSaleProducts(id));
            saleDto.setCartId(sale.getCartId());
            saleDto.setTotal(cartApi.getCartById(sale.getCartId()).getTotal());
        }
        return saleDto;
    }
}
