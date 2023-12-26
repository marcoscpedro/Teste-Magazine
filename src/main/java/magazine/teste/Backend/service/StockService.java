package magazine.teste.Backend.service;

import java.util.List;

import magazine.teste.Backend.controller.dtos.SaleItemDto;


public interface StockService {

    boolean verifyStockQuantity(List<SaleItemDto> saleItems);

    void stockMovement(List<SaleItemDto> saleItems);
    
}
