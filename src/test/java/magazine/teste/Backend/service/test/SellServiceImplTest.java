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
import org.springframework.web.server.ResponseStatusException;

import magazine.teste.Backend.controller.dtos.SaleItemDto;
import magazine.teste.Backend.controller.dtos.SellDto;
import magazine.teste.Backend.model.Sale;
import magazine.teste.Backend.service.SellService;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class SellServiceImplTest {
	
	@Autowired
	private SellService sellService;

	@Test
    public void testCompareSalesValueWithCostValueSuccessful() {
		
		List<SaleItemDto> saleItems = new ArrayList<>();
		
        SaleItemDto saleItem = new SaleItemDto();
        saleItem.setName("Coca Cola");
        saleItem.setProductDiscount(0.1);
        saleItem.setProductId(1L);
        saleItem.setQuantity(5);
        
        saleItems.add(saleItem);
        
        boolean valid = sellService.compareSalesValueWithCostValue(saleItems);
        
        assert valid == true;
    }
	
	@Test
    public void testCompareSalesValueWithCostValueFail() {
		
		List<SaleItemDto> saleItems = new ArrayList<>();
		
        SaleItemDto saleItem = new SaleItemDto();
        saleItem.setName("Coca Cola");
        saleItem.setProductDiscount(0.36);
        saleItem.setProductId(1L);
        saleItem.setQuantity(5);
        
        saleItems.add(saleItem);
        
        boolean valid = sellService.compareSalesValueWithCostValue(saleItems);
        
        assert valid == false;
    }
	
	@Test
    public void testSelling() {
		
		SellDto sellDto = new SellDto();
		sellDto.setCustomerId(1L);
		
		List<SaleItemDto> saleItems = new ArrayList<>();
		
        SaleItemDto saleItem = new SaleItemDto();
        saleItem.setName("Coca Cola");
        saleItem.setProductDiscount(0.1);
        saleItem.setProductId(1L);
        saleItem.setQuantity(5);
        
        saleItems.add(saleItem);
        
        sellDto.setItens(saleItems);
        
        Sale sale = sellService.selling(sellDto);
        
        assert sale.getCustomer().getId() == 1L;
        assert sale.getTotalSaleValue() == 84.75975;
    }
	
	@Test
    public void testSellingValidationFailed() {
		
		SellDto sellDto = new SellDto();
		sellDto.setCustomerId(1L);
		
		List<SaleItemDto> saleItems = new ArrayList<>();
		
        SaleItemDto saleItem = new SaleItemDto();
        saleItem.setName("Coca Cola");
        saleItem.setProductDiscount(0.5);
        saleItem.setProductId(1L);
        saleItem.setQuantity(5);
        
        saleItems.add(saleItem);
        
        sellDto.setItens(saleItems);
        
        try {
        	sellService.selling(sellDto);
            assert false : "Não teve exceção";
        } catch (ResponseStatusException e) {
        	assert e.getBody().getDetail() == "Favor verificar a quantidade e o desconto";
        }
    }
}
