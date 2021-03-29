package by.epam.training.javaWEB.finalTask.dao;

import by.epam.training.javaWEB.finalTask.dao.daoInterface.SupplierDAO;
import by.epam.training.javaWEB.finalTask.dao.daoInterface.SupplyDAO;
import by.epam.training.javaWEB.finalTask.dao.daoInterface.UserDAO;
import by.epam.training.javaWEB.finalTask.dao.daoInterface.UserDetailDAO;
import by.epam.training.javaWEB.finalTask.dao.impl.SQLSupplierDAO;
import by.epam.training.javaWEB.finalTask.dao.impl.SQLSupplyDAO;
import by.epam.training.javaWEB.finalTask.dao.impl.SQLUserDAO;
import by.epam.training.javaWEB.finalTask.dao.impl.SQLUserDetailDAO;

public class DAOProvider {
    private static final DAOProvider instance = new DAOProvider();

    private final UserDAO userDAO = new SQLUserDAO();
    private final UserDetailDAO userDetailDAO = new SQLUserDetailDAO();
    private final SupplyDAO supplyDAO = new SQLSupplyDAO();
    private final SupplierDAO supplierDAO = new SQLSupplierDAO();

    private DAOProvider() {}

    public static DAOProvider getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public UserDetailDAO getUserDetailDAO() {
        return userDetailDAO;
    }

    public SupplyDAO getSupplyDAO() {
        return supplyDAO;
    }

    public SupplierDAO getSupplierDAO() {
        return supplierDAO;
    }
}
