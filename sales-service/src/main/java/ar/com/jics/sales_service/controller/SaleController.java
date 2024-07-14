package ar.com.jics.sales_service.controller;

import ar.com.jics.sales_service.dto.SaleDTO;
import ar.com.jics.sales_service.model.Sale;
import ar.com.jics.sales_service.service.ISaleService;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private ISaleService service;

    @GetMapping("/")
    public ResponseEntity<List<Sale>> getAllSales(){

        List<Sale> sales = service.getAllSales();
        if(sales != null || !sales.isEmpty()){
            return ResponseEntity.ok(sales);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDTO> getSaleById(@PathVariable Long id){

        SaleDTO sale = service.getDetailedSale(id);

        if(sale != null && sale.getId() == id){
            return ResponseEntity.ok(sale);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<String> saveSale(@RequestBody Sale sale) {


        boolean isSaved = service.saveSale(sale);

        if (isSaved) {
            return ResponseEntity.ok("Sale successfully saved");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save sale");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSale(@PathVariable Long id,
                             @RequestBody Sale sale){
        boolean isUpdated = service.updateSale(id, sale);
        if(isUpdated){
            return ResponseEntity.ok("Sale successfully updated");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update sale");

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSale(@PathVariable Long id){
        boolean isDeleted = service.deleteSale(id);

        if(isDeleted){
            return ResponseEntity.ok("Sale successfully deleted");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete sale");
        }
    }
}
