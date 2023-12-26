package magazine.teste.Backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import magazine.teste.Backend.controller.dtos.ProductReportDto;
import magazine.teste.Backend.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(name = "getProductReport", nativeQuery = true)
    List<ProductReportDto> getProductReport();


}

