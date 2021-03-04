package by.epam.training.javaWEB.finalTask.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Product implements Serializable {
    private int idProduct;
    private String name;
    private double currentPrice;
    private double currentQuantity;
    private String description;
    private String imageLink;
    private int totalQuantity;
    private double totalRating;

    private ArrayList<ProductDetail> details = new ArrayList<>();

    public Product() {
    }

    public Product(int idProduct, String name, double currentPrice, double currentQuantity, String description, String imageLink, int totalQuantity, double totalRating) {
        this.idProduct = idProduct;
        this.name = name;
        this.currentPrice = currentPrice;
        this.currentQuantity = currentQuantity;
        this.description = description;
        this.imageLink = imageLink;
        this.totalQuantity = totalQuantity;
        this.totalRating = totalRating;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(double currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public double getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(double totalRating) {
        this.totalRating = totalRating;
    }

    public ArrayList<ProductDetail> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<ProductDetail> details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return idProduct == product.idProduct &&
                Double.compare(product.currentPrice, currentPrice) == 0 &&
                Double.compare(product.currentQuantity, currentQuantity) == 0 &&
                totalQuantity == product.totalQuantity &&
                Double.compare(product.totalRating, totalRating) == 0 &&
                name.equals(product.name) &&
                description.equals(product.description) &&
                imageLink.equals(product.imageLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, name, currentPrice, currentQuantity, description, imageLink, totalQuantity, totalRating);
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", currentPrice=" + currentPrice +
                ", currentQuantity=" + currentQuantity +
                ", description='" + description + '\'' +
                ", imageLink='" + imageLink + '\'' +
                ", totalQuantity=" + totalQuantity +
                ", totalRating=" + totalRating +
                '}';
    }
}
