package magazine.teste.Backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int stockQuantity;
    private double costValue;
    private double profitMargin;
    
    public Product(){}

    public Product (String name, int stockQuantity, double costValue, double profitMargin){
        this.name = name;
        this.stockQuantity = stockQuantity;
        this.costValue = costValue;
        this.profitMargin = profitMargin;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    public double getCostValue() {
        return costValue;
    }
    public void setCostValue(double costValue) {
        this.costValue = costValue;
    }
    public double getProfitMargin() {
        return profitMargin;
    }
    public void setProfitMargin(double profitMargin) {
        this.profitMargin = profitMargin;
    }

   
}
