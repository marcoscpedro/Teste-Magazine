package magazine.teste.Backend.service;

import java.util.List;

import magazine.teste.Backend.model.Product;

public interface ProductService {

    Iterable<Product> getAllProducts();

    Product getProductById(Long productId);

    Product createProduct(Product product);

    Product updateProduct(Long productId, Product product);

    void deleteProduct(Long productId);

    List<magazine.teste.Backend.controller.dtos.ProductReportDto> getProductReport();
}
