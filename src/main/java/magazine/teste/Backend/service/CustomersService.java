package magazine.teste.Backend.service;

import magazine.teste.Backend.model.Customers;

public interface CustomersService {
    
    Iterable<Customers> getAllCustomers();

    Customers getCustomerById(Long customerId);

    Customers createCustomers(Customers customer);

    Customers updateCustomers(Long customerId, Customers customer);

    void deleteCustomers(Long customerId);

}
