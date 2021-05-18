package by.epam.training.javaWEB.finalTask.dao.daoInterface;

import by.epam.training.javaWEB.finalTask.bean.Rating;
import by.epam.training.javaWEB.finalTask.bean.Service;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.dao.impl.Parameter;

import java.util.List;

public interface ServiceDAO {
    boolean addService(Service service) throws DAOException;
    boolean deleteService(Service service) throws DAOException;
    List<Service> getBy(Parameter parameter, Object ... value) throws DAOException;
    List<Service> getServiceList() throws DAOException;
    boolean update(Parameter parameter, int serviceId, Object value) throws DAOException;
}
