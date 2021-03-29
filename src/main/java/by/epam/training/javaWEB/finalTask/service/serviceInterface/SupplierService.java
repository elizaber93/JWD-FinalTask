package by.epam.training.javaWEB.finalTask.service.serviceInterface;

import by.epam.training.javaWEB.finalTask.bean.Supplier;
import by.epam.training.javaWEB.finalTask.service.exception.ServiceException;

import java.util.List;

public interface SupplierService {
    boolean addSupplier(Supplier supplier);
    boolean isFound(Supplier supplier) throws ServiceException;
}
