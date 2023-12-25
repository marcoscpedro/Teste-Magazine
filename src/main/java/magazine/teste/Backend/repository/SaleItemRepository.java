package magazine.teste.Backend.repository;

import org.springframework.data.repository.CrudRepository;

import magazine.teste.Backend.model.SaleItem;

public interface SaleItemRepository extends CrudRepository<SaleItem, Long> {
    
}
