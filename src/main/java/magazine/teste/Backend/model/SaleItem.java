package magazine.teste.Backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class SaleItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private double productDiscount;
    private double productFinalValue;
    private Long saleId;    
    private Long productId;

    public SaleItem(){}

    public SaleItem(int quantity, Long saleId, Long productId, double productDiscount, double productFinalValue){
        this.quantity = quantity;
        this.saleId = saleId;
        this.productId = productId;
        this.productDiscount = productDiscount;
        this.productFinalValue = productFinalValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSaleId() {
        return saleId;
    }
    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }
    public double getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(double productDiscount) {
        this.productDiscount = productDiscount;
    }
    
    public double getProductFinalValue() {
        return productFinalValue;
    }

    public void setProductFinalValue(double productFinalValue) {
        this.productFinalValue = productFinalValue;
    }
}
