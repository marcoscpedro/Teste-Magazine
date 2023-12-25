package magazine.teste.Backend.datainit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import magazine.teste.Backend.model.Product;
import magazine.teste.Backend.repository.ProductRepository;

@Component
public class ProductSeed {
    
    private final ProductRepository productRepository;

    public ProductSeed(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void seedDatabase(){

        Product product = new Product("Coca Cola", 100, 12.99, 1.45);
        Product product1 = new Product("Fanta Uva", 15, 7.99, 1.15);
        Product product2 = new Product("Fanta Laranja", 50, 10.99, 1.30);
        Product product3 = new Product("Tubaina", 0, 6.99, 1.1);

        productRepository.save(product);
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
    }

}
