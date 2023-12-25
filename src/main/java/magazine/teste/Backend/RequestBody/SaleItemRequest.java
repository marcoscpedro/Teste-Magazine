package magazine.teste.Backend.RequestBody;

public class SaleItemRequest {
    private Long productId;
    private String name;
    private int quantity;
    private double productDiscount;
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getProductDiscount() {
        return productDiscount;
    }
    public void setProductDiscount(double productDiscount) {
        this.productDiscount = productDiscount;
    }
}
