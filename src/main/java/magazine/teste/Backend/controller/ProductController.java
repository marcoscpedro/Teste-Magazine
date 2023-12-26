package magazine.teste.Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import magazine.teste.Backend.controller.dtos.ProductDto;
import magazine.teste.Backend.model.Product;
import magazine.teste.Backend.service.ProductService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping
    public Iterable<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @PostMapping
    public Product createProduct(@Valid @RequestBody ProductDto product){
        return productService.createProduct(product.toProduct());
    }

    @PutMapping("/{productId}")
    public  ResponseEntity<Product> updateProduct(@PathVariable Long productId,@Valid @RequestBody ProductDto product){
        Product updatedProduct = productService.updateProduct(productId, product.toProduct());
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
    }
}
