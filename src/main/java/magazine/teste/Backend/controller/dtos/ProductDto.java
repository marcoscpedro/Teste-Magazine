package magazine.teste.Backend.controller.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import magazine.teste.Backend.model.Product;

public class ProductDto {
    
    @Valid
    @NotEmpty(message = "The name field can not be empty or null")
    private String name;

    @Valid
    @NotNull(message = "The stock quantity field can not be empty or null")
    private Integer stockQuantity;
    
    @Valid
    @NotNull(message = "The cost value field can not be empty or null")
    private Double costValue;
    
    @Valid
    @NotNull(message = "The profit margin field can not be empty or null")
    private Double profitMargin;

    public Product toProduct(){
        Product newProduct = new Product();
        newProduct.setName(this.name);
        newProduct.setStockQuantity(this.stockQuantity);
        newProduct.setCostValue(this.costValue);
        newProduct.setProfitMargin(this.profitMargin);
        System.out.println(newProduct);
        return newProduct;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getStockQuantity() {
        return stockQuantity;
    }
    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    public Double getCostValue() {
        return costValue;
    }
    public void setCostValue(Double costValue) {
        this.costValue = costValue;
    }
    public Double getProfitMargin() {
        return profitMargin;
    }
    public void setProfitMargin(Double profitMargin) {
        this.profitMargin = profitMargin;
    }

}
