package magazine.teste.Backend.service;

import magazine.teste.Backend.model.Customer;

public interface CustomerService {
    
    Iterable<Customer> getAllCustomers();

    Customer getCustomerById(Long customerId);

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Long customerId, Customer customer);

    void deleteCustomer(Long customerId);

}
