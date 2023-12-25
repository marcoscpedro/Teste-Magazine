package magazine.teste.Backend.service;

import java.util.List;

import magazine.teste.Backend.RequestBody.SaleItemRequest;


public interface StockService {

    boolean verifyStockQuantity(List<SaleItemRequest> saleItems);

    void stockMovement(List<SaleItemRequest> saleItems);
    
}
