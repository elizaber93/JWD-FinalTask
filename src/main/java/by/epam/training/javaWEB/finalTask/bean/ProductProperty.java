package by.epam.training.javaWEB.finalTask.bean;

import java.io.Serializable;
import java.util.Objects;

public class ProductProperty implements Serializable {
    private int idProperty;
    private String name;

    public ProductProperty() {
    }

    public ProductProperty(int idProperty, String name) {
        this.idProperty = idProperty;
        this.name = name;
    }

    public int getIdProperty() {
        return idProperty;
    }

    public void setIdProperty(int idProperty) {
        this.idProperty = idProperty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductProperty)) return false;
        ProductProperty that = (ProductProperty) o;
        return idProperty == that.idProperty &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProperty, name);
    }

    @Override
    public String toString() {
        return "ProductProperty{" +
                "idProperty=" + idProperty +
                ", name='" + name + '\'' +
                '}';
    }
}
