package co.uk.aarondev.shoppingcart;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductDao, Long> {

}
