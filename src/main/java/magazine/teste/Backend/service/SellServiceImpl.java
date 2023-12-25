package magazine.teste.Backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import magazine.teste.Backend.RequestBody.SaleItemRequest;
import magazine.teste.Backend.RequestBody.SellRequest;
import magazine.teste.Backend.model.Product;
import magazine.teste.Backend.model.Sale;
import magazine.teste.Backend.model.SaleItem;
import magazine.teste.Backend.repository.ProductRepository;
import magazine.teste.Backend.repository.SaleItemRepository;
import magazine.teste.Backend.repository.SaleRepository;

@Service
public class SellServiceImpl implements SellService {
    
    private ProductRepository productRepository;
    private SaleRepository saleRepository;
    private SaleItemRepository saleItemRepository;

    public SellServiceImpl (ProductRepository productRepository, SaleRepository saleRepository, SaleItemRepository saleItemRepository){
        this.productRepository = productRepository;
        this.saleRepository = saleRepository;
        this.saleItemRepository = saleItemRepository;
    }

    @Override
    public double calculateSaleValue(SaleItem[] saleItems, double discount){
        double totalBuyValue = 0;
        for(SaleItem saleItem : saleItems){
            Product productBuyed = productRepository.findById(saleItem.getProductId()).orElse(null);
            double itemValueWithOutDiscount = productBuyed.getCostValue() * productBuyed.getProfitMargin();
            totalBuyValue = itemValueWithOutDiscount * discount;
        }        
        return totalBuyValue;
    }
    
    @Override
    public boolean compareSalesValueWithCostValue(List<SaleItemRequest> saleItems){
        boolean canContinue = true;
        for (SaleItemRequest saleItem : saleItems){
            Product productSaleItem = productRepository.findById(saleItem.getProductId()).orElse(null);
            if (productSaleItem == null) {
                return canContinue = false;
            }
            double salesValueWithoutDiscountAndMargin = saleItem.getQuantity() * productSaleItem.getCostValue();
            double salesValueWithoutDiscount = salesValueWithoutDiscountAndMargin * productSaleItem.getProfitMargin();
            double salesValue = salesValueWithoutDiscount * saleItem.getProductDiscount();
            if (salesValue < productSaleItem.getCostValue()) {
                canContinue = false;
            }
        }
        return canContinue;
    }

    @Override
    public Sale selling (SellRequest sellRequest){
        Sale newSale = new Sale(0, sellRequest.getCustomerId());
        Sale currentSale = saleRepository.save(newSale);
        double totalSaleValue =  createSaleItem(sellRequest, currentSale.getId());
        Sale finalSale = updateSaleTotalValue(currentSale, totalSaleValue);
        return finalSale;
    }

    private double createSaleItem (SellRequest sellRequest, Long saleId){
        double totalBuyValue = 0;
        for (SaleItemRequest saleItem : sellRequest.getItens()){
            Product product = productRepository.findById(saleItem.getProductId()).orElse(null);
            double priceWhitOutDiscount = product.getCostValue() * product.getProfitMargin();
            double finalPrice = priceWhitOutDiscount * saleItem.getQuantity();
            SaleItem savingSaleItem = new SaleItem(saleItem.getQuantity(), saleId, saleItem.getProductId(), saleItem.getProductDiscount(), finalPrice);
            saleItemRepository.save(savingSaleItem);
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
