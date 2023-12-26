package magazine.teste.Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import magazine.teste.Backend.model.Customer;
import magazine.teste.Backend.service.CustomerService;
import magazine.teste.Backend.controller.dtos.CustomerDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {
    
    @Autowired
    private CustomerService customersService;

    
    @GetMapping
    public Iterable<Customer> getAllCustomers(){
        return customersService.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        Customer customer = customersService.getCustomerById(customerId);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        
    }

    @PostMapping
    public Customer createCustomer(@Valid @RequestBody CustomerDto customer) {
        return customersService.createCustomer(customer.toCustomer());
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer (@PathVariable Long customerId,@Valid @RequestBody CustomerDto customer){
        Customer updatedCustomer = customersService.updateCustomer(customerId, customer.toCustomer());
        if (updatedCustomer != null) {
            return ResponseEntity.ok(updatedCustomer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId){
        customersService.deleteCustomer(customerId);
    }
}
