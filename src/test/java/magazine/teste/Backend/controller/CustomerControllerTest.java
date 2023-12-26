package magazine.teste.Backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateCustomer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/customers")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"name\": \"Teste1\", \"email\": \"teste1\", \"cpf\": \"cpf1\"}"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testNameFieldCustomer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/customers")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"nameee\": \"Teste1\", \"email\": \"teste1\", \"cpf\": \"cpf1\"}"))
            .andExpect(MockMvcResultMatchers.status().isBadRequest());
}
    @Test
    public void testEmailFieldCustomer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/customers")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"name\": \"Teste1\", \"emailer\": \"teste1\", \"cpf\": \"cpf1\"}"))
            .andExpect(MockMvcResultMatchers.status().isBadRequest());
}
    @Test
    public void testCpfFieldCustomer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/customers")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"name\": \"Teste1\", \"email\": \"teste1\", \"cpf32\": \"cpf1\"}"))
            .andExpect(MockMvcResultMatchers.status().isBadRequest());
}
    @Test
    public void testGetCustomers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/customers"))
            .andExpect(MockMvcResultMatchers.status().isOk());
}
    @Test
    public void testGetCustomersById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/2"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testGetCustomersByIdWhenIsNull() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/99999999"))
            .andExpect(MockMvcResultMatchers.status().isNotFound());
}

    @Test
    public void testUpdateCustomer() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/api/customers/2")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\": \"Alterou\", \"email\": \"Alterou\", \"cpf\": \"Alterou\"}"))
        .andExpect(MockMvcResultMatchers.status().isOk());  
    }

    @Test
    public void testUpdateNameFieldCustomer() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/api/customers/2")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name32\": \"Alterou\", \"email\": \"Alterou\", \"cpf\": \"Alterou\"}"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());  
    }

    @Test
    public void testUpdateEmailFieldCustomer() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/api/customers/2")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\": \"Alterou\", \"emai434\": \"Alterou\", \"cpf\": \"Alterou\"}"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());  
    }
    
    @Test
    public void testUpdateCpfFieldCustomer() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/api/customers/2")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\": \"Alterou\", \"email\": \"Alterou\", \"cpf43\": \"Alterou\"}"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());  
    }
    
    @Test
    public void testUpdateCustomerNotFound() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/api/customers/99999")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\": \"Alterou\", \"email\": \"Alterou\", \"cpf\": \"Alterou\"}"))
        .andExpect(MockMvcResultMatchers.status().isNotFound());  
    }

    @Test
    public void testDeleteCustomer() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/customers/1"))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

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
        mockMvc.perform(MockMvcRequestBuilders.put("/api/products/2")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\": \"Mudou\", \"stockQuantity\": \"232\", \"costValue\": \"15.20\", \"profitMargin\": \" 2.99\" }"))
        .andExpect(MockMvcResultMatchers.status().isOk());  
    }

    @Test
    public void testNameFieldUpdateProduct() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/api/products/2")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"nameds\": \"Mudou\", \"stockQuantity\": \"232\", \"costValue\": \"15.20\", \"profitMargin\": \" 2.99\" }"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());  
    }

    @Test
    public void testStockQuantityFieldUpdateProduct() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/api/products/2")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\": \"Mudou\", \"stockQuantity43\": \"232\", \"costValue\": \"15.20\", \"profitMargin\": \" 2.99\" }"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());  
    }

    @Test
    public void testCostValueFieldUpdateProduct() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/api/products/2")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\": \"Mudou\", \"stockQuantity\": \"232\", \"costValueqw\": \"15.20\", \"profitMargin\": \" 2.99\" }"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());  
    }

    @Test
    public void testProfitMarginFieldUpdateProduct() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.put("/api/products/2")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\": \"Mudou\", \"stockQuantity\": \"232\", \"costValue\": \"15.20\", \"profitMarginsds\": \" 2.99\" }"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());  
    }

    @Test
    public void testDeleteProduct() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/product/1"))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testReportProducts() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/reports/products"))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }    
    
    @Test
    public void testSell() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/customers")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"customerId\": \"1\", \"itens\": \"[\"productId\", \"1\", \"quantity\", \"1\", \"productDiscount\", \"0.10\"  ]\"}"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }
}