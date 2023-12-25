package magazine.teste.Backend.controller;

import javax.management.RuntimeErrorException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import magazine.teste.Backend.RequestBody.SellRequest;
import magazine.teste.Backend.model.Sale;
import magazine.teste.Backend.repository.ProductRepository;
import magazine.teste.Backend.repository.SaleItemRepository;
import magazine.teste.Backend.repository.SaleRepository;
import magazine.teste.Backend.service.SaleService;
import magazine.teste.Backend.service.SellService;
import magazine.teste.Backend.service.StockService;

@RestController
@RequestMapping("/api/sells")
public class SellController {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleItemRepository saleItemRepository;

    private StockService stockService;
    private SellService sellService;
    private SaleService saleService;

    public SellController(StockService stockService, SellService sellService, SaleService saleService){
        this.stockService = stockService;
        this.sellService = sellService;
        this.saleService = saleService;
        
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Sale selling(@Valid @RequestBody SellRequest sellRequest){
        
            boolean stockValidation = stockService.verifyStockQuantity(sellRequest.getItens());
            boolean priceValidation = sellService.compareSalesValueWithCostValue(sellRequest.getItens());
            if (stockValidation == false || priceValidation == false) {
                throw new RuntimeErrorException(null, "Favor verificar a quantidade e o desconto");       
            }
            Sale currentSale = sellService.selling(sellRequest);
            stockService.stockMovement(sellRequest.getItens());
            return currentSale;                   
    }
//  ResponseEntity<SellRequest>
}
