package magazine.teste.Backend.RequestBody;

import java.util.List;

public class SellRequest {
    private Long customerId;
    private List<SaleItemRequest>  itens;
    
    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public List<SaleItemRequest> getItens() {
        return itens;
    }
    public void setItens(List<SaleItemRequest> itens) {
        this.itens = itens;
    }
}

