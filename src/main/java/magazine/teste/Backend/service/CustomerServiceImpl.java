package magazine.teste.Backend.service;

import org.springframework.stereotype.Service;

import magazine.teste.Backend.model.Customer;
import magazine.teste.Backend.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
    
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository custumerRepository){
        this.customerRepository = custumerRepository;
    }

    @Override
    public Iterable<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById (Long custumerId) {
        return customerRepository.findById(custumerId).orElse(null);
    }

    @Override
    public Customer createCustomer(Customer custumer) {
        return customerRepository.save(custumer);
    }

    @Override
    public Customer updateCustomer(Long custumerId, Customer custumer){
        Customer customerFocus = customerRepository.findById(custumerId).orElse(null);
        customerFocus.setName(custumer.getName());
        customerFocus.setEmail(custumer.getEmail());
        customerFocus.setCpf(custumer.getCpf());
        return customerRepository.save(customerFocus);
    }

    @Override
    public void deleteCustomer(Long custumerId){
        customerRepository.deleteById(custumerId);
    }


}
