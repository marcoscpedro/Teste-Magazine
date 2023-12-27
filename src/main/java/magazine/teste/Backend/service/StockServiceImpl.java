package magazine.teste.Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import magazine.teste.Backend.controller.dtos.SaleItemDto;
import magazine.teste.Backend.model.Product;
import magazine.teste.Backend.repository.ProductRepository;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean verifyStockQuantity(List<SaleItemDto> saleItems){
        boolean canContinue = true;
        for (SaleItemDto saleItem : saleItems){
            Product stockProduct = productRepository.findById(saleItem.getProductId()).orElse(null);
            if (stockProduct == null || stockProduct.getStockQuantity() < saleItem.getQuantity() ) {
                return canContinue = false;
            }
        }
        return canContinue;
    }

    @Override
    public void stockMovement(List<SaleItemDto> saleItems){
        for (SaleItemDto saleItem : saleItems){
            Product product = productRepository.findById(saleItem.getProductId()).orElse(null);
            int finalStockQuantity = product.getStockQuantity() - saleItem.getQuantity();
            product.setStockQuantity(finalStockQuantity);
            productRepository.save(product);
        }
    }
    
}
