package magazine.teste.Backend.service;

import magazine.teste.Backend.model.SaleItem;

public interface SaleItemService {
    
    Iterable<SaleItem> getAllSaleItems();

    SaleItem getSaleItemById(Long saleItemId);

    SaleItem createSaleItem(SaleItem saleItem);

    SaleItem updateSaleItem(Long saleItemId, SaleItem saleItem);

    void deleteSaleItem(Long saleItemId);
}
