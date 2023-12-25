package magazine.teste.Backend.service;

import org.springframework.stereotype.Service;

import magazine.teste.Backend.model.Customer;
import magazine.teste.Backend.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
    
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository costumerRepository){
        this.customerRepository = costumerRepository;
    }

    @Override
    public Iterable<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById (Long costumerId) {
        return customerRepository.findById(costumerId).orElse(null);
    }

    @Override
    public Customer createCustomer(Customer costumer) {
        return customerRepository.save(costumer);
    }

    @Override
    public Customer updateCustomer(Long costumerId, Customer costumer){
        Customer customerFocus = customerRepository.findById(costumerId).orElse(null);
        customerFocus.setName(costumer.getName());
        customerFocus.setEmail(costumer.getEmail());
        customerFocus.setCpf(costumer.getCpf());
        return customerRepository.save(customerFocus);
    }

    @Override
    public void deleteCustomer(Long costumerId){
        customerRepository.deleteById(costumerId);
    }


}
