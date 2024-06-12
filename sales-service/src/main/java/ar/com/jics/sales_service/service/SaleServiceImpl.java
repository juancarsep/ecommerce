package ar.com.jics.sales_service.service;

import ar.com.jics.sales_service.model.Sale;
import ar.com.jics.sales_service.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements ISaleService{

    @Autowired
    ISaleRepository repo;

    @Override
    public void saveSale(Sale sale) {
        repo.save(sale);
    }

    @Override
    public Sale getSale(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Sale> getAllSales() {
        return repo.findAll();
    }

    @Override
    public void updateSale(Long id, Sale newSale) {
        Sale sale = this.getSale(id);
        if(sale!=null){
            sale.setProducts(newSale.getProducts());
            sale.setTotal(newSale.getTotal());
            repo.save(sale);
        }else{
            System.out.println("The Sale with ID: " + id + " does not exist.");
        }
    }

    @Override
    public void deleteSale(Long id) {
        repo.deleteById(id);
    }
}
