package by.epam.training.javaWEB.finalTask.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class Supply implements Serializable {
    private int idSupply;
    private int supplierId;
    private int idProduct;
    private String document;
    private Timestamp date;
    private double manufacturerPrice;
    private double discountPrice;
    private int quantity;

    public Supply() {
    }

    public Supply(int idSupply, int idProduct, String document, Timestamp date, double manufacturerPrice, double discountPrice, int quantity) {
        this.idSupply = idSupply;
        this.idProduct = idProduct;
        this.document = document;
        this.date = date;
        this.manufacturerPrice = manufacturerPrice;
        this.discountPrice = discountPrice;
        this.quantity = quantity;
    }

    public int getIdSupply() {
        return idSupply;
    }

    public void setIdSupply(int idSupply) {
        this.idSupply = idSupply;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public double getManufacturerPrice() {
        return manufacturerPrice;
    }

    public void setManufacturerPrice(double manufacturerPrice) {
        this.manufacturerPrice = manufacturerPrice;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Supply)) return false;
        Supply supply = (Supply) o;
        return idSupply == supply.idSupply &&
                idProduct == supply.idProduct &&
                Double.compare(supply.manufacturerPrice, manufacturerPrice) == 0 &&
                Double.compare(supply.discountPrice, discountPrice) == 0 &&
                quantity == supply.quantity &&
                document.equals(supply.document) &&
                date.equals(supply.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSupply, idProduct, document, date, manufacturerPrice, discountPrice, quantity);
    }

    @Override
    public String toString() {
        return "Supply{" +
                "idSupply=" + idSupply +
                ", idProduct=" + idProduct +
                ", document='" + document + '\'' +
                ", date=" + date +
                ", manufacturerPrice=" + manufacturerPrice +
                ", discountPrice=" + discountPrice +
                ", quantity=" + quantity +
                '}';
    }
}
