package magazine.teste.Backend.repository;


import org.springframework.data.repository.CrudRepository;

import magazine.teste.Backend.model.Customers;

public interface CustomersRepository extends CrudRepository<Customers, Long>  {

    
}
