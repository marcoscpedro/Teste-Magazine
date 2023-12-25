package magazine.teste.Backend.service;

import org.springframework.stereotype.Service;

import magazine.teste.Backend.model.Product;
import magazine.teste.Backend.model.SaleItem;
import magazine.teste.Backend.repository.ProductRepository;
import magazine.teste.Backend.repository.SaleItemRepository;

@Service
public class StockServiceImpl implements StockService {

    private ProductRepository productRepository;
    private SaleItemRepository saleItemRepository;

    public StockServiceImpl(ProductRepository productRepository, SaleItemRepository saleItemRepository){
        this.productRepository = productRepository;
        this.saleItemRepository = saleItemRepository;
    }

    @Override
    public boolean verifyStockQuantity(SaleItem[] saleItems){
        boolean canContinue = true;
        for (SaleItem saleItem : saleItems){
            Product stockProduct = productRepository.findById(saleItem.getProductId()).orElse(null);
            if (stockProduct.getStockQuantity() < saleItem.getQuantity()) {
                canContinue = false;
            }
        }
        return canContinue;
    }

    @Override
    public Product stockMovement(Long productId, Product product){
        Product stockProduct = productRepository.findById(productId).orElse(null);
        int finalStockQuantity = stockProduct.getStockQuantity() - product.getStockQuantity();
        stockProduct.setStockQuantity(finalStockQuantity);
        return productRepository.save(stockProduct);
    }
    
}
