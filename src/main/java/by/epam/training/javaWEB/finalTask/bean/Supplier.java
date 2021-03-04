package by.epam.training.javaWEB.finalTask.bean;

import java.io.Serializable;
import java.util.Objects;

public class Supplier implements Serializable {
    private int idSupplier;
    private String name;
    private String requisites;

    public Supplier() {
    }

    public Supplier(int idSupplier, String name, String requisites) {
        this.idSupplier = idSupplier;
        this.name = name;
        this.requisites = requisites;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Supplier)) return false;
        Supplier supplier = (Supplier) o;
        return idSupplier == supplier.idSupplier &&
                name.equals(supplier.name) &&
                requisites.equals(supplier.requisites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSupplier, name, requisites);
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "idSupplier=" + idSupplier +
                ", name='" + name + '\'' +
                ", requisites='" + requisites + '\'' +
                '}';
    }
}
