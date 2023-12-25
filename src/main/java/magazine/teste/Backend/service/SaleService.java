package magazine.teste.Backend.service;

import magazine.teste.Backend.model.Sale;

public interface SaleService {
    
    Iterable<Sale> getAllSales();

    Sale getSaleById(Long saleId);

    Sale createSale(Sale sale);

    Sale updateSale(Long saleId, Sale sale);

    void deleteSale(Long saleId);

}
