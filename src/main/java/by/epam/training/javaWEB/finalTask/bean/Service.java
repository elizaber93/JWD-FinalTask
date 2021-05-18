package by.epam.training.javaWEB.finalTask.bean;

import java.io.Serializable;
import java.util.Objects;

public class Service implements Serializable {
    private int idService;
    private String name;
    private double price;
    private String description;
    private double totalRating;
    private String category;
    private String status;

    public Service() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Service(int idService, String name, double price, String description, double totalRating) {
        this.idService = idService;
        this.name = name;
        this.price = price;
        this.description = description;
        this.totalRating = totalRating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(double totalRating) {
        this.totalRating = totalRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Service)) return false;
        Service service = (Service) o;
        return idService == service.idService &&
                Double.compare(service.price, price) == 0 &&
                Double.compare(service.totalRating, totalRating) == 0 &&
                name.equals(service.name) &&
                description.equals(service.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idService, name, price, description, totalRating);
    }

    @Override
    public String toString() {
        return "Service{" +
                "idService=" + idService +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", totalRating=" + totalRating +
                ", category='" + category + '\'' +
                '}';
    }
}
