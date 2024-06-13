package ar.com.jics.sales_service.controller;

import ar.com.jics.sales_service.dto.SaleDTO;
import ar.com.jics.sales_service.model.Sale;
import ar.com.jics.sales_service.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    ISaleService service;

    @GetMapping("/")
    public List<Sale> getAllSales(){
        return service.getAllSales();
    }

    @GetMapping("/{id}")
    public SaleDTO getSaleById(@PathVariable Long id){
        return service.getDetailedSale(id);
    }

    @PostMapping("/")
    public String saveSale(@RequestBody Sale sale){
        service.saveSale(sale);
        return "Sale successfully saved";
    }

    @PutMapping("/{id}")
    public String updateSale(@PathVariable Long id,
                             @RequestBody Sale sale){
        service.updateSale(id, sale);
        return "Sale successfully updated";
    }

    @DeleteMapping("/{id}")
    public String deleteSale(@PathVariable Long id){
        service.deleteSale(id);
        return "Sale successfully deleted";
    }
}
