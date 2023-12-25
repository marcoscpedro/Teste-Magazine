package magazine.teste.Backend.service;

import org.springframework.stereotype.Service;

import magazine.teste.Backend.model.Product;
import magazine.teste.Backend.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    
    private ProductRepository productRepository;
    
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Override
    public Product getProductById (Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public Product createProduct (Product product){
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct (Long productId, Product product){
        Product product_focus = productRepository.findById(productId).orElse(null);
        product_focus.setName(product.getName());
        product_focus.setStockQuantity(product.getStockQuantity());
        product_focus.setCostValue(product.getCostValue());
        product_focus.setProfitMargin(product.getProfitMargin());
        return productRepository.save(product_focus);
    }

    @Override
    public void deleteProduct(Long productId){
        productRepository.deleteById(productId);
    }

}
