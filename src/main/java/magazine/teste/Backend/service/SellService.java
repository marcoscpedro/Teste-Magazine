package magazine.teste.Backend.service;

import java.util.List;

import magazine.teste.Backend.controller.dtos.SaleItemDto;
import magazine.teste.Backend.controller.dtos.SellDto;
import magazine.teste.Backend.model.Sale;

public interface SellService {
    
    boolean compareSalesValueWithCostValue(List<SaleItemDto> saleItems);

    Sale selling(SellDto sellRequest);
}
