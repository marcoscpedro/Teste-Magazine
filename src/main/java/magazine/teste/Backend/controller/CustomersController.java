package magazine.teste.Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import magazine.teste.Backend.model.Customers;
import magazine.teste.Backend.repository.CustomersRepository;

@RestController
@RequestMapping("/api/costumers")
public class CustomersController {
    
    @Autowired
    private CustomersRepository costumerRepository;
    


    @GetMapping
    public Iterable<Customers> getAllCostumers(){
        Customers costumer1 = new Customers();
        costumer1.setName("Marcos");
        costumerRepository.save(costumer1);
        return costumerRepository.findAll();
    }
}
