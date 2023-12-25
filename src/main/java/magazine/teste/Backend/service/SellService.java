package magazine.teste.Backend.service;

import magazine.teste.Backend.model.Product;
import magazine.teste.Backend.model.Sale;
import magazine.teste.Backend.model.SaleItem;

public interface SellService {
    
    double calculateSaleValue(SaleItem[] saleitems, double discount);

    boolean compareSalesValueWithCostValue(Sale sale, SaleItem[] saleitems);

    Sale selling(Sale sale, SaleItem[] saleitems);
}
