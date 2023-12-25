package magazine.teste.Backend.datainit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import magazine.teste.Backend.model.Customer;
import magazine.teste.Backend.repository.CustomerRepository;

@Component
public class CustomerSeed {
    
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerSeed(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @PostConstruct
    public void seedDatabase(){

        Customer customer = new Customer("Marcos", "marcos@gmail.com", "123124");
        Customer customer1 = new Customer("Pedro", "pedro@gmail.com", "12314124");
        Customer customer2 = new Customer("Melo", "melo@gmail.com", "11235412");

        customerRepository.save(customer);
        customerRepository.save(customer1);
        customerRepository.save(customer2);

    }

}
