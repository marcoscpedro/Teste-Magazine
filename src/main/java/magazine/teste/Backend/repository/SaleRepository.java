package magazine.teste.Backend.repository;

import org.springframework.data.repository.CrudRepository;

import magazine.teste.Backend.model.Sale;

public interface SaleRepository extends CrudRepository<Sale, Long> {
    
}
