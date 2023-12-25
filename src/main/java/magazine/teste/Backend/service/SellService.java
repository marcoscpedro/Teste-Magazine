package magazine.teste.Backend.service;

import java.util.List;

import magazine.teste.Backend.RequestBody.SaleItemRequest;
import magazine.teste.Backend.RequestBody.SellRequest;
import magazine.teste.Backend.model.Sale;
import magazine.teste.Backend.model.SaleItem;

public interface SellService {
    
    double calculateSaleValue(SaleItem[] saleitems, double discount);

    boolean compareSalesValueWithCostValue(List<SaleItemRequest> saleItems);

    Sale selling(SellRequest sellRequest);
}
