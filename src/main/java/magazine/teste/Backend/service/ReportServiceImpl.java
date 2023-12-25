package magazine.teste.Backend.service;

import org.springframework.stereotype.Service;

import magazine.teste.Backend.model.Product;
import magazine.teste.Backend.repository.ProductRepository;

@Service
public class ReportServiceImpl implements ReportService {
    
    private ProductRepository productRepository;

    public ReportServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> findAllProductsByStockQuantity(){
        return productRepository.findAllProductsByStockQuantity();
    }
    

}
