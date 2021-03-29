package by.epam.training.javaWEB.finalTask.bean.builder;

import by.epam.training.javaWEB.finalTask.bean.Product;

public class ProductBuilder {

    private Product product;

    public ProductBuilder() {
        product = new Product();
    }

    public ProductBuilder(Product product) {
        this.product = product;
    }

    public ProductBuilder setName(String name) {
        this.product.setName(name);
        return this;
    }

    public ProductBuilder setDescription(String description) {
        this.product.setDescription(description);
        return this;
    }

    public ProductBuilder setImageLink(String imageLink){
        product.setImageLink(imageLink);
        return this;
    }

    public ProductBuilder setCurrentPrice(double price) {
        product.setCurrentPrice(price);
        return this;
    }

    public  ProductBuilder setCurrentQuantity(int quantity){
        product.setCurrentQuantity(quantity);
        return this;
    }

    public ProductBuilder setTotalRating(int rating) {
        product.setTotalRating(rating);
        return this;
    }

    public ProductBuilder setTotalQuantity(int quantity){
        product.setTotalQuantity(quantity);
        return this;
    }

    public ProductBuilder setProductId(int id) {
        product.setIdProduct(id);
        return this;
    }

    public Product build() {
        return this.product;
    }
}
