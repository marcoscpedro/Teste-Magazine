package magazine.teste.Backend.service;

import org.springframework.stereotype.Service;

import magazine.teste.Backend.model.Customers;
import magazine.teste.Backend.repository.CustomersRepository;

@Service
public class CustomersServiceImpl implements CustomersService {
    
    private CustomersRepository customersRepository;

    public CustomersServiceImpl(CustomersRepository costumerRepository){
        this.customersRepository = costumerRepository;
    }

    @Override
    public Iterable<Customers> getAllCustomers(){
        return customersRepository.findAll();
    }

    @Override
    public Customers getCustomerById (Long costumerId) {
        return customersRepository.findById(costumerId).orElse(null);
    }

    @Override
    public Customers createCustomers(Customers costumer) {
        return customersRepository.save(costumer);
    }

    @Override
    public Customers updateCustomers(Long costumerId, Customers costumer){
        Customers customer_focus = customersRepository.findById(costumerId).orElse(null);
        customer_focus.setName(costumer.getName());
        customer_focus.setEmail(costumer.getEmail());
        return customersRepository.save(customer_focus);
    }

    @Override
    public void deleteCustomers(Long costumerId){
        customersRepository.deleteById(costumerId);
    }


}
