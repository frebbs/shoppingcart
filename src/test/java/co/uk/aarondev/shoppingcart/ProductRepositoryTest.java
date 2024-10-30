package co.uk.aarondev.shoppingcart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void findAll_shouldReturnAllProducts() {
        Iterable<ProductDao> all = productRepository.findAll();
        List<ProductDao> products = StreamSupport.stream(all.spliterator(), false).toList();

        assertThat(products.size()).isEqualTo(15);
    }
}
