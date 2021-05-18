package by.epam.training.javaWEB.finalTask.dao.daoInterface;

import by.epam.training.javaWEB.finalTask.dao.DAOException;

import java.util.Map;

public interface EnumDAO {
    Map<Integer,String> getRoles() throws DAOException;
    Map<Integer,String> getCategories() throws DAOException;
    Map<Integer,String> getStatuses() throws DAOException;
    Map<Integer,String> getDeliveryMethods() throws DAOException;
    Map<Integer,String> getPaymentMethods() throws DAOException;
}
