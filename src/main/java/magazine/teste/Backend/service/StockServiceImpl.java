package magazine.teste.Backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import magazine.teste.Backend.RequestBody.SaleItemRequest;
import magazine.teste.Backend.model.Product;
import magazine.teste.Backend.repository.ProductRepository;

@Service
public class StockServiceImpl implements StockService {

    private ProductRepository productRepository;

    public StockServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;

    }

    @Override
    public boolean verifyStockQuantity(List<SaleItemRequest> saleItems){
        boolean canContinue = true;
        for (SaleItemRequest saleItem : saleItems){
            Product stockProduct = productRepository.findById(saleItem.getProductId()).orElse(null);
            if (stockProduct.getStockQuantity() >= saleItem.getQuantity() || stockProduct == null) {
                return canContinue = false;
            }
        }
        return canContinue;
    }

    @Override
    public void stockMovement(List<SaleItemRequest> saleItems){
        for (SaleItemRequest saleItem : saleItems){
            Product product = productRepository.findById(saleItem.getProductId()).orElse(null);
            int finalStockQuantity = product.getStockQuantity() - saleItem.getQuantity();
            product.setStockQuantity(finalStockQuantity);
            productRepository.save(product);
        }
    }
    
}
