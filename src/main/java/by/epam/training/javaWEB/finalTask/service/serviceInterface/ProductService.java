package by.epam.training.javaWEB.finalTask.service.serviceInterface;

import by.epam.training.javaWEB.finalTask.bean.Product;
import by.epam.training.javaWEB.finalTask.bean.ProductProperty;
import by.epam.training.javaWEB.finalTask.bean.Service;
import by.epam.training.javaWEB.finalTask.service.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface ProductService {
    boolean addProduct(Product product) throws ServiceException;
    boolean addService(Service service) throws ServiceException;
    void updateProduct(int id, Product product) throws ServiceException;
    void updateService(int id, Service service) throws ServiceException;
    void deleteProduct(int id) throws ServiceException;
    void deleteService(int id) throws ServiceException;
    List<ProductProperty> getPropertyList() throws ServiceException;
    List<Product> getProductList() throws ServiceException;
    List<Service> getServiceList() throws ServiceException;
    Map<Integer,String> getCategories() throws ServiceException;
    Map<Integer,String> getStatuses() throws ServiceException;


}
