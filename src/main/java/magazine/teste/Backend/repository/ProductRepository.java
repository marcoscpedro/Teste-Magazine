package magazine.teste.Backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import magazine.teste.Backend.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
 
    @Query("SELECT p.id, p.name, p.stockQuantity FROM Product p where p.stockQuantity > 0 ORDER BY p.stockQuantity DESC")
    List<Product> findAllProductsByStockQuantity();
    
}

