package by.epam.training.javaWEB.finalTask.bean;

import java.io.Serializable;
import java.util.Objects;

public class ProductDetail implements Serializable {
    private int idProductDetail;
    private int idProduct;
    private int idProperty;
    private String propertyName;
    private String value;

    public ProductDetail() {
    }

    public ProductDetail(String propertyName, String value) {
        this.propertyName = propertyName;
        this.value = value;
    }

    public ProductDetail(int idProductDetail, int idProduct, int idProperty, String value) {
        this.idProductDetail = idProductDetail;
        this.idProduct = idProduct;
        this.idProperty = idProperty;
        this.value = value;
    }

    public int getIdProductDetail() {
        return idProductDetail;
    }

    public void setIdProductDetail(int idProductDetail) {
        this.idProductDetail = idProductDetail;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdProperty() {
        return idProperty;
    }

    public void setIdProperty(int idProperty) {
        this.idProperty = idProperty;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDetail)) return false;
        ProductDetail that = (ProductDetail) o;
        return idProductDetail == that.idProductDetail &&
                idProduct == that.idProduct &&
                idProperty == that.idProperty &&
                value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProductDetail, idProduct, idProperty, value);
    }

    @Override
    public String toString() {
        return "ProductDetail{" +
                "idProductDetail=" + idProductDetail +
                ", idProduct=" + idProduct +
                ", idProperty=" + idProperty +
                ", value='" + value + '\'' +
                '}';
    }
}
