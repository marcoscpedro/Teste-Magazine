package magazine.teste.Backend.service;

import org.springframework.stereotype.Service;

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
    public boolean compareSalesValueWithCostValue(Sale sale, SaleItem[] saleItems){
        boolean canContinue = true;
        for (SaleItem saleItem : saleItems){
            Product productSaleItem = productRepository.findById(saleItem.getProductId()).orElse(null);
            double salesValueWithoutDiscountAndMargin = saleItem.getQuantity() * productSaleItem.getCostValue();
            double salesValueWithoutDiscount = salesValueWithoutDiscountAndMargin * productSaleItem.getProfitMargin();
            double salesValue = salesValueWithoutDiscount * sale.getSaleDiscount();
            if (salesValue < productSaleItem.getCostValue()) {
                canContinue = false;
            }
        }
        return canContinue;
    }

    @Override
    public Sale selling (Sale sale, SaleItem[] saleItems){
        Sale newSale = new Sale(0, sale.getSaleDiscount(), sale.getCustomerId());
        Sale currentSale = saleRepository.save(newSale);

        for (SaleItem saleItem : saleItems){
            SaleItem savingSaleItem = new SaleItem(saleItem.getQuantity(), currentSale.getId(), saleItem.getProductId());
            saleItemRepository.save(savingSaleItem);
        }
        return currentSale;
    }
}
