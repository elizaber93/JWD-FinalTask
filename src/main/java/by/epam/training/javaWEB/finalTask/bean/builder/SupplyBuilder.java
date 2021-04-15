package by.epam.training.javaWEB.finalTask.bean.builder;

import by.epam.training.javaWEB.finalTask.bean.Supply;

import java.sql.Timestamp;

public class SupplyBuilder {


    private Supply supply;

    public SupplyBuilder() {
        this.supply = new Supply();
    }

    public SupplyBuilder setDate(Timestamp date) {
        supply.setDate(date);
        return this;
    }

    public SupplyBuilder setId(int id) {
        supply.setIdSupply(id);
        return this;
    }

    public SupplyBuilder setSupplierID(int id) {
        supply.setSupplierId(id);
        return this;
    }

    public SupplyBuilder setProductId(int id) {
        supply.setIdProduct(id);
        return this;
    }

    public SupplyBuilder setDocument(String document) {
        supply.setDocument(document);
        return this;
    }

    public SupplyBuilder setManufacturerPrice(double price) {
        supply.setManufacturerPrice(price);
        return this;
    }

    public SupplyBuilder setQuantity(int quantity) {
        supply.setQuantity(quantity);
        return this;
    }

    public SupplyBuilder setDiscountPrice(double price) {
        supply.setDiscountPrice(price);
        return this;
    }

    public Supply build() {
        return supply;
    }



}
