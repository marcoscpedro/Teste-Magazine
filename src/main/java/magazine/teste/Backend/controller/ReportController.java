package magazine.teste.Backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import magazine.teste.Backend.ResponseBody.ReportResponse;
import magazine.teste.Backend.service.ReportService;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    
    @Autowired
    private ReportService reportService;

    public ReportController(ReportService reportService){
        this.reportService = reportService;
    }

    @GetMapping("/stockQuantity")
    public List<ReportResponse>findAllProductsByStockQuantity(){
        return reportService.mainReport();
       }
    
}
