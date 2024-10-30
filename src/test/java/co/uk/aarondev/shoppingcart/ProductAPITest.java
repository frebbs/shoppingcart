package co.uk.aarondev.shoppingcart;

import co.uk.aarondev.shoppingcart.model.Product;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class ProductAPITest {

    @Value(value = "${local.server.port}")
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    public void findAllProducts_shouldReturnAllProducts() {

        var response = given()
                .accept(ContentType.JSON)
                .get("/api/product")
                .then()
                .assertThat()
                .statusCode(200);

        List<Product> results = response.extract().as(new TypeRef<List<Product>>(){});
        assertThat(results.size()).isGreaterThan(5);
        var appleWatch = results.stream().filter(product -> product.getName().equals("Apple Watch")).findFirst();
        assertThat(appleWatch).isNotEmpty();
    }

    @Test
    public void findProductById_shouldReturnSingleProduct() {
        var response = given()
                .accept(ContentType.JSON)
                .get("/api/product/2")
                .then()
                .assertThat()
                .statusCode(200);

        Product result = response.extract().as(Product.class);
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("iPhone 16 Pro Max");
    }
}
