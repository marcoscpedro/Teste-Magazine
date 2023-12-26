package magazine.teste.Backend.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import magazine.teste.Backend.controller.dtos.SellDto;
import magazine.teste.Backend.model.Sale;
import magazine.teste.Backend.service.SellService;
import magazine.teste.Backend.service.StockService;

@RestController
@RequestMapping("/api/sells")
public class SellController {
    
    @Autowired
    private StockService stockService;

    @Autowired
    private SellService sellService;

    
    @PostMapping
    public Sale selling(@Valid @RequestBody SellDto sellRequest){
        
            // boolean stockValidation = stockService.verifyStockQuantity(sellRequest.getItens());
            // boolean priceValidation = sellService.compareSalesValueWithCostValue(sellRequest.getItens());
            // if (stockValidation == false || priceValidation == false) {
            //     throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Favor verificar a quantidade e o desconto");
            // }
            Sale currentSale = sellService.selling(sellRequest);
            // stockService.stockMovement(sellRequest.getItens());
            return currentSale;                   
    }
}
