package magazine.teste.Backend.model;

import java.util.List;

import org.hibernate.annotations.NamedNativeQuery;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SqlResultSetMapping;
import magazine.teste.Backend.controller.dtos.ProductReportDto;

@Entity
@NamedNativeQuery(
	    name = "getProductReport",	    
	    query =
	        "SELECT " + 
	        "  sum(si.quantity) as selledQuantity, " + 
	        "  p.stock_quantity as stockQuantity, " + 
	        "  p.id, " +
	        "  p.name, " +
	        "  ((si.product_final_value / si.quantity) - p.cost_value) as profit " +
	        "FROM sale_item si " + 
	        "join product p on p.id = si.product_id " +  
	        "GROUP by p.stock_quantity, p.id, p.name, ((si.product_final_value / si.quantity) - p.cost_value)",
	    resultSetMapping = "productReportDto"
	)
	@SqlResultSetMapping(
	    name = "productReportDto",
	    classes = @ConstructorResult(
	        targetClass = ProductReportDto.class,
	        columns = {
	            @ColumnResult(name = "id", type = Long.class),
	            @ColumnResult(name = "name", type = String.class),
	            @ColumnResult(name = "selledQuantity", type = Integer.class),
	            @ColumnResult(name = "stockQuantity", type = Integer.class),
	            @ColumnResult(name = "profit", type = Double.class)
	        }
	    )
	)

public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int stockQuantity;
    private double costValue;
    private double profitMargin;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<SaleItem> saleItems;

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
