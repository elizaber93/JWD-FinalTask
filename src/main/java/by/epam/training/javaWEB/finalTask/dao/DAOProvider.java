package by.epam.training.javaWEB.finalTask.dao;

import by.epam.training.javaWEB.finalTask.dao.daoInterface.*;
import by.epam.training.javaWEB.finalTask.dao.impl.*;

public class DAOProvider {
    private static final DAOProvider instance = new DAOProvider();

    private final UserDAO userDAO = new SQLUserDAO();
    private final UserDetailDAO userDetailDAO = new SQLUserDetailDAO();
    private final SupplyDAO supplyDAO = new SQLSupplyDAO();
    private final SupplierDAO supplierDAO = new SQLSupplierDAO();
    private final ProductDetailDAO productDetailDAO = new SQLProductDetailDAO();
    private final ProductDAO productDAO = new SQLProductDAO();
    private final ServiceDAO serviceDAO = new SQLServiceDAO();
    private final EnumDAO enumDAO = new SQLEnumDAO();
    private DAOProvider() {}

    public EnumDAO getEnumDAO() {
        return enumDAO;
    }

    public ServiceDAO getServiceDAO() {
        return serviceDAO;
    }


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

    public ProductDetailDAO getProductDetailDAO() {
        return productDetailDAO;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }
}
