import {Product} from "./api/shoppingcartSchemas.ts";
import {useFindAllProducts} from "./api/shoppingcartComponents.ts";

export const ProductList = () => {
    const { data: products, isLoading, error } = useFindAllProducts({
        headers: {},
        queryParams: {}
    });

    if (isLoading) {
        return <div>Loading products...</div>;
    }

    if (error) {
        return <div>Error loading products</div>;
    }

    if (!products) {
        return <div>No products found</div>;
    }

    return (
        <div>
            <h1>Product List 2026</h1>

            {products.map((product: Product) => (
                <article
                    key={product.id}
                    style={{
                        border: "1px solid #ddd",
                        padding: "16px",
                        marginBottom: "16px",
                        borderRadius: "8px"
                    }}
                >
                    <h2> {product.name} </h2>
                    <p> £{product.price?.toLocaleString()} </p>
                    <p> {product.description} </p>
                </article>
            ))}
        </div>
    );
};