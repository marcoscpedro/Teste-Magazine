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
public class CustomersControllerTest {

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
}