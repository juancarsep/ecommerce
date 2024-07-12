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
    private ISaleService service;

    @GetMapping("/")
    public List<Sale> getAllSales(){
        return service.getAllSales();
    }

    @GetMapping("/{id}")
    public SaleDTO getSaleById(@PathVariable Long id){
        return service.getDetailedSale(id);
    }

    @PostMapping("/")
    public String saveSale(@RequestBody Sale sale) {


        boolean isSaved = service.saveSale(sale);

        if (isSaved) {
            return "Sale successfully saved";
        } else {
            return "Failed to save sale";
        }
    }

    @PutMapping("/{id}")
    public String updateSale(@PathVariable Long id,
                             @RequestBody Sale sale){
        boolean isUpdated = service.updateSale(id, sale);
        if(isUpdated){
            return "Sale successfully updated";
        }else{
            return "Failed to update sale";

        }
    }

    @DeleteMapping("/{id}")
    public String deleteSale(@PathVariable Long id){
        boolean isDeleted = service.deleteSale(id);

        if(isDeleted){
            return "Sale successfully deleted";
        }else{
            return "Failed to delete sale";
        }


    }
}
