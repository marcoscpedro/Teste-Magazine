package magazine.teste.Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import magazine.teste.Backend.model.Customer;
import magazine.teste.Backend.repository.CustomerRepository;
import magazine.teste.Backend.service.CustomerService;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/customer")
public class CustomersController {
    
    @Autowired
    private CustomerRepository customerRepository;

    private CustomerService customersService;

    public CustomersController(CustomerService customersService){
        this.customersService = customersService;
    }
    
    @GetMapping
    public Iterable<Customer> getAllCustomers(){
        return customersService.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId) {
        return customersService.getCustomerById(customerId);
    }

    @PostMapping

    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return customersService.createCustomer(customer);
    }

    @PutMapping("/{customerId}")
    public Customer updateCustomer (@PathVariable Long customerId, @RequestBody Customer customers){
        return customersService.updateCustomer(customerId, customers);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId){
        customersService.deleteCustomer(customerId);
    }
}
