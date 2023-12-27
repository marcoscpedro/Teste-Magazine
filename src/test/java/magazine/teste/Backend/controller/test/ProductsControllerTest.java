package magazine.teste.Backend.controller.test;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class ProductsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateProduct() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/products")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\": \"Fanta\", \"stockQuantity\": \"20\", \"costValue\": \"20.99\", \"profitMargin\": \" 1.1\" }"))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testNameFieldProduct() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/products")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name23\": \"Fanta\", \"stockQuantity\": \"20\", \"costValue\": \"20.99\", \"profitMargin\": \" 1.1\" }"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testStockQuantityFieldProduct() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/products")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\": \"Fanta\", \"stockQuantity43\": \"20\", \"costValue\": \"20.99\", \"profitMargin\": \" 1.1\" }"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testCostValueFieldProduct() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/products")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\": \"Fanta\", \"stockQuantity\": \"20\", \"costValue434\": \"20.99\", \"profitMargin\": \" 1.1\" }"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testProfitMarginFieldProduct() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/products")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\": \"Fanta\", \"stockQuantity\": \"20\", \"costValue\": \"20.99\", \"profitMargin434\": \" 1.1\" }"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testGetProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/products"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetProductById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/products/1"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetProductsByIdWhenIsNull() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/products/99999999"))
            .andExpect(MockMvcResultMatchers.status().isNotFound());
    }


    @Test
    public void testUpdateProduct() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/api/products/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\": \"Mudou\", \"stockQuantity\": \"232\", \"costValue\": \"15.20\", \"profitMargin\": \" 2.99\" }"))
        .andExpect(MockMvcResultMatchers.status().isOk());  
    }

    @Test
    public void testNameFieldUpdateProduct() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/api/products/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"nameds\": \"Mudou\", \"stockQuantity\": \"232\", \"costValue\": \"15.20\", \"profitMargin\": \" 2.99\" }"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());  
    }

    @Test
    public void testStockQuantityFieldUpdateProduct() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/api/products/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\": \"Mudou\", \"stockQuantity43\": \"232\", \"costValue\": \"15.20\", \"profitMargin\": \" 2.99\" }"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());  
    }

    @Test
    public void testCostValueFieldUpdateProduct() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/api/products/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\": \"Mudou\", \"stockQuantity\": \"232\", \"costValueqw\": \"15.20\", \"profitMargin\": \" 2.99\" }"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());  
    }

    @Test
    public void testProfitMarginFieldUpdateProduct() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/api/products/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\": \"Mudou\", \"stockQuantity\": \"232\", \"costValue\": \"15.20\", \"profitMarginsds\": \" 2.99\" }"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());  
    }

    @Test
    public void testDeleteProduct() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/products/3"))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
