package by.epam.training.javaWEB.finalTask.service;

import by.epam.training.javaWEB.finalTask.service.impl.SupplierServiceImpl;
import by.epam.training.javaWEB.finalTask.service.impl.UserServiceImpl;
import by.epam.training.javaWEB.finalTask.service.impl.ValidationServiceImpl;
import by.epam.training.javaWEB.finalTask.service.serviceInterface.SupplierService;
import by.epam.training.javaWEB.finalTask.service.serviceInterface.UserService;
import by.epam.training.javaWEB.finalTask.service.serviceInterface.ValidationService;

public final class ServiceProvider {
    private static final ServiceProvider instance = new ServiceProvider();

    private ServiceProvider() {}

    private final UserService userService = new UserServiceImpl();
    private final ValidationService validationService = new ValidationServiceImpl();
    private final SupplierService supplierService = new SupplierServiceImpl();
    //private final NewsService newsService = new NewsServiceImpl();

    public static ServiceProvider getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }

    public ValidationService getValidationService() {return validationService;}

    public SupplierService getSupplierService() {
        return supplierService;
    }

    /*public NewsService getNewsService() {
        return newsService;
    }

     */

}
