package magazine.teste.Backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
    public void testCreateCustomer() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/api/customers"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().json("{\"id\": 1, \"name\": \"Teste1\", \"email\": \"teste1\", \"cpf\": \"cpf1\"}"));
    }

    
    
}