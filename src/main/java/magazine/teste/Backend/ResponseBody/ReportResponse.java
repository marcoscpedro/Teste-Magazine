package magazine.teste.Backend.ResponseBody;

public class ReportResponse {
    private Long id;
    private String name;
    private int selledQuantity;
    private int stockQuantity;
    private double profit;
    
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
    public int getSelledQuantity() {
        return selledQuantity;
    }
    public void setSelledQuantity(int selledQuantity) {
        this.selledQuantity = selledQuantity;
    }
    public int getStockQuantity() {
        return stockQuantity;
    }
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    public double getProfit() {
        return profit;
    }
    public void setProfit(double profit) {
        this.profit = profit;
    }

}
