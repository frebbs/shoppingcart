package co.uk.aarondev.shoppingcart;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product")
public class ProductDao {
    @Id
    @GeneratedValue
    private Long id;

    private String description;

    private String name;

    private Long price;

    private String picture;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public String getPicture() {
        return picture;
    }
}
