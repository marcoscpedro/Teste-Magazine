package magazine.teste.Backend.repository;


import org.springframework.data.repository.CrudRepository;

import magazine.teste.Backend.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>  {

    
}
