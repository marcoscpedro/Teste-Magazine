package magazine.teste.Backend.controller.dtos;

import java.util.List;

public class SellDto {
    private Long customerId;
    private List<SaleItemDto>  itens;
    
    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public List<SaleItemDto> getItens() {
        return itens;
    }
    public void setItens(List<SaleItemDto> itens) {
        this.itens = itens;
    }
}

