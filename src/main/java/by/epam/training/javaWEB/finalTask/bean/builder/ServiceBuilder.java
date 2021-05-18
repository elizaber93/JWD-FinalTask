package by.epam.training.javaWEB.finalTask.bean.builder;

import by.epam.training.javaWEB.finalTask.bean.Rating;
import by.epam.training.javaWEB.finalTask.bean.Service;

public class ServiceBuilder {

    private Service service;

    public ServiceBuilder() {
        service = new Service();
    }

    public ServiceBuilder setId(int id) {
        this.service.setIdService(id);
        return this;
    }

    public ServiceBuilder setName(String name) {
        this.service.setName(name);
        return this;
    }

    public ServiceBuilder setPrice(double price) {
        this.service.setPrice(price);
        return this;
    }

    public ServiceBuilder setDescription(String description) {
        this.service.setDescription(description);
        return this;
    }

    public ServiceBuilder setRating(double rating) {
        this.service.setTotalRating(rating);
        return this;
    }

    public ServiceBuilder setCategory(String name) {
        this.service.setCategory(name);
        return this;
    }

    public ServiceBuilder setStatus(String status) {
        this.service.setStatus(status);
        return this;
    }

    public Service build() {
        return this.service;
    }
}
