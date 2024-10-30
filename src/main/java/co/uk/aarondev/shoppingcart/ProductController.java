package co.uk.aarondev.shoppingcart;

import co.uk.aarondev.shoppingcart.api.ProductApi;
import co.uk.aarondev.shoppingcart.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.StreamSupport;

@Controller
public class ProductController implements ProductApi {

    final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<List<Product>> findAllProducts() {
        var products = StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .map(productDao -> new Product()
                        .id(productDao.getId())
                        .description(productDao.getDescription())
                        .name(productDao.getName())
                        .price(productDao.getPrice())
                        .picture(productDao.getPicture()))
                .toList();

        return ResponseEntity.ok(products);
    }

    @Override
    public ResponseEntity<Product> getProductById(Long productId) {
        return productRepository.findById(productId)
                .map(productDao -> new Product()
                        .id(productDao.getId())
                        .description(productDao.getDescription())
                        .name(productDao.getName())
                        .price(productDao.getPrice())
                        .picture(productDao.getPicture()))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
