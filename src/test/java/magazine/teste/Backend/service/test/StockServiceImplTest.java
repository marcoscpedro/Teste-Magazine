package magazine.teste.Backend.service.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import magazine.teste.Backend.controller.dtos.SaleItemDto;
import magazine.teste.Backend.model.Product;
import magazine.teste.Backend.service.ProductService;
import magazine.teste.Backend.service.StockService;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class StockServiceImplTest {
	
	@Autowired
	private StockService stockService;
	
	@Autowired
	private ProductService productService;

	@Test
    public void testVerifyStockQuantitySuccessful() {
		
		List<SaleItemDto> saleItems = new ArrayList<>();
		
        SaleItemDto saleItem = new SaleItemDto();
        saleItem.setName("Coca Cola");
        saleItem.setProductDiscount(0.36);
        saleItem.setProductId(1L);
        saleItem.setQuantity(5);
        
        saleItems.add(saleItem);
        
        boolean valid = stockService.verifyStockQuantity(saleItems);
        
        assert valid == true;
    }
	
	@Test
    public void testVerifyStockQuantityFailByQuantity() {
		
		List<SaleItemDto> saleItems = new ArrayList<>();
		
        SaleItemDto saleItem = new SaleItemDto();
        saleItem.setName("Coca Cola");
        saleItem.setProductDiscount(0.36);
        saleItem.setProductId(1L);
        saleItem.setQuantity(500);
        
        saleItems.add(saleItem);
        
        boolean valid = stockService.verifyStockQuantity(saleItems);
        
        assert valid == false;
    }
	
	@Test
    public void testVerifyStockQuantityFailByNotFoundProduct() {
		
		List<SaleItemDto> saleItems = new ArrayList<>();
		
        SaleItemDto saleItem = new SaleItemDto();
        saleItem.setName("Fanta");
        saleItem.setProductDiscount(0.36);
        saleItem.setProductId(999L);
        saleItem.setQuantity(1);
        
        saleItems.add(saleItem);
        
        boolean valid = stockService.verifyStockQuantity(saleItems);
        
        assert valid == false;
    }
	
	@Test
    public void testStockMovement() {
		
		List<SaleItemDto> saleItems = new ArrayList<>();
		
        SaleItemDto saleItem = new SaleItemDto();
        saleItem.setName("Coca Cola");
        saleItem.setProductDiscount(0.36);
        saleItem.setProductId(1L);
        saleItem.setQuantity(50);
        
        saleItems.add(saleItem);
        
        stockService.stockMovement(saleItems);
        
        Product product = productService.getProductById(saleItem.getProductId());
        
        assert product.getStockQuantity() == 50;
    }
	
}

