package magazine.teste.Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import magazine.teste.Backend.model.Sale;
import magazine.teste.Backend.model.SaleItem;
import magazine.teste.Backend.repository.ProductRepository;
import magazine.teste.Backend.repository.SaleItemRepository;
import magazine.teste.Backend.repository.SaleRepository;
import magazine.teste.Backend.service.SaleService;
import magazine.teste.Backend.service.SellService;
import magazine.teste.Backend.service.StockService;

@RestController
@RequestMapping("/api/sell")
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
    public Sale selling(@RequestBody Sale sale, @RequestBody SaleItem[] saleitems){
        stockService.verifyStockQuantity(saleitems);
        sellService.compareSalesValueWithCostValue(sale, saleitems);
        Sale currentSale =  sellService.selling(sale, saleitems);
        double totalBuyValue = sellService.calculateSaleValue(saleitems, sale.getSaleDiscount());
        currentSale.setTotalSaleValue(totalBuyValue);
        return saleService.updateSale(currentSale.getId(), currentSale);
    }
 
}
