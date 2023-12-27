package magazine.teste.Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import magazine.teste.Backend.controller.dtos.SaleItemDto;
import magazine.teste.Backend.controller.dtos.SellDto;
import magazine.teste.Backend.model.Customer;
import magazine.teste.Backend.model.Product;
import magazine.teste.Backend.model.Sale;
import magazine.teste.Backend.model.SaleItem;
import magazine.teste.Backend.repository.CustomerRepository;
import magazine.teste.Backend.repository.ProductRepository;
import magazine.teste.Backend.repository.SaleItemRepository;
import magazine.teste.Backend.repository.SaleRepository;

@Service
public class SellServiceImpl implements SellService {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleItemRepository saleItemRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private StockService stockService;
    
    @Override
    public boolean compareSalesValueWithCostValue(List<SaleItemDto> saleItems){
        boolean canContinue = true;
        for (SaleItemDto saleItem : saleItems){
            Product productSaleItem = productRepository.findById(saleItem.getProductId()).orElse(null);
            if (productSaleItem == null) {
                return canContinue = false;
            }
            double salesValueWithoutDiscountAndMargin = productSaleItem.getCostValue();
            double salesValueWithoutDiscount = salesValueWithoutDiscountAndMargin * productSaleItem.getProfitMargin();
            double salesValue = salesValueWithoutDiscount - (salesValueWithoutDiscount * saleItem.getProductDiscount());
            if (salesValue < productSaleItem.getCostValue()) {
                canContinue = false;
            }
        }
        return canContinue;
    }
    
    @Override
    public Sale selling (SellDto sellRequest){
        boolean stockValidation = stockService.verifyStockQuantity(sellRequest.getItens());
        boolean priceValidation = compareSalesValueWithCostValue(sellRequest.getItens());
        if (stockValidation == false || priceValidation == false) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Favor verificar a quantidade e o desconto");
            }
        Customer customer = customerRepository.findById(sellRequest.getCustomerId()).orElse(null);
        Sale newSale = new Sale();
        newSale.setTotalSaleValue(0);
        newSale.setCustomer(customer);
        Sale currentSale = saleRepository.save(newSale);
        double totalSaleValue =  createSaleItem(sellRequest, currentSale);
        Sale finalSale = updateSaleTotalValue(currentSale, totalSaleValue);
        stockService.stockMovement(sellRequest.getItens());
        return finalSale;
    }

    private double createSaleItem (SellDto sellRequest, Sale sale){
        double totalBuyValue = 0;
        for (SaleItemDto saleItem : sellRequest.getItens()){
            Product product = productRepository.findById(saleItem.getProductId()).orElse(null);
            double priceWhitOutDiscount = product.getCostValue() * product.getProfitMargin() * saleItem.getQuantity();
            double finalPrice = priceWhitOutDiscount - (priceWhitOutDiscount * saleItem.getProductDiscount());

            SaleItem savingSaleItem = new SaleItem();
            savingSaleItem.setQuantity(saleItem.getQuantity());
            savingSaleItem.setSale(sale);
            savingSaleItem.setProduct(product);
            savingSaleItem.setProductDiscount(saleItem.getProductDiscount());
            savingSaleItem.setProductFinalValue(finalPrice);
                        
            totalBuyValue += finalPrice;
        }
        return totalBuyValue;
    }

    private Sale updateSaleTotalValue (Sale sale, double totalSaleValue){
        Sale initiaSale = sale;
        initiaSale.setTotalSaleValue(totalSaleValue);
        return saleRepository.save(initiaSale);
    }
}
