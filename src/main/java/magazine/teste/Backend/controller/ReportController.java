package magazine.teste.Backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import magazine.teste.Backend.controller.dtos.ProductReportDto;
import magazine.teste.Backend.service.ProductService;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    
    @Autowired
    private ProductService productService;

    @GetMapping("/products")    
    public List<ProductReportDto> getProductReport(){
        return productService.getProductReport();
    }
}
