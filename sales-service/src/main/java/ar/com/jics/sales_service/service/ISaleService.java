package ar.com.jics.sales_service.service;

import ar.com.jics.sales_service.dto.ProductDTO;
import ar.com.jics.sales_service.dto.SaleDTO;
import ar.com.jics.sales_service.model.Sale;

import java.util.List;

public interface ISaleService {
    public boolean saveSale(Sale sale);
    public Sale getSale(Long id);
    public List<Sale> getAllSales();
    public boolean updateSale(Long id, Sale sale);
    public boolean deleteSale(Long id);
    public SaleDTO getDetailedSale(Long id);
}
