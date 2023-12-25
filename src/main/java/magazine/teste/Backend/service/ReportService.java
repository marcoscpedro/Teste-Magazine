package magazine.teste.Backend.service;

import magazine.teste.Backend.model.Product;

public interface ReportService {

    Iterable<Product>findAllProductsByStockQuantity();
    
}
