package magazine.teste.Backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import magazine.teste.Backend.model.Product;
import magazine.teste.Backend.service.ReportService;

@RestController
@RequestMapping("/api/report")
public class ReportController {
    
    private ReportService reportService;

    public ReportController(ReportService reportService){
        this.reportService = reportService;
    }

    @GetMapping("/{stockQuantity}")
    public Iterable<Product> findAllProductsByStockQuantity(){
        return reportService.findAllProductsByStockQuantity();
    }
    
}
