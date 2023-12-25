package magazine.teste.Backend.service;

import magazine.teste.Backend.model.Product;
import magazine.teste.Backend.model.SaleItem;

public interface StockService {

    boolean verifyStockQuantity(SaleItem[] saleItems);

    Product stockMovement(Long productId, Product product);
    
}
