package magazine.teste.Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import magazine.teste.Backend.controller.dtos.ProductReportDto;
import magazine.teste.Backend.model.Product;
import magazine.teste.Backend.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public Iterable<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Override
    public Product getProductById (Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        return product;
    }

    @Override
    public Product createProduct (Product product){
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct (Long productId, Product product){
        Product product_focus = productRepository.findById(productId).orElse(null);
        if (product_focus == null) {
            return product_focus;
        }
        product_focus.setName(product.getName());
        product_focus.setStockQuantity(product.getStockQuantity());
        product_focus.setCostValue(product.getCostValue());
        product_focus.setProfitMargin(product.getProfitMargin());
        productRepository.save(product_focus);
        return product_focus;
    }

    @Override
    public void deleteProduct(Long productId){
        productRepository.deleteById(productId);
    }

    @Override
    public List<ProductReportDto> getProductReport(){
        return productRepository.getProductReport();
    }

}
