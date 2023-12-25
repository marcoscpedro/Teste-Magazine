package magazine.teste.Backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Sale {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double totalSaleValue;
        
    private Long customerId;
    
    public Sale(){

    }

    public Sale(double totalSaleValue, Long customerId){
        this.totalSaleValue = totalSaleValue;
        this.customerId = customerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotalSaleValue() {
        return totalSaleValue;
    }

    public void setTotalSaleValue(double totalSaleValue) {
        this.totalSaleValue = totalSaleValue;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    

}
