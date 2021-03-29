package by.epam.training.javaWEB.finalTask.dao.daoInterface;

import by.epam.training.javaWEB.finalTask.bean.Product;
import by.epam.training.javaWEB.finalTask.dao.DAOException;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    boolean addProduct(Product product) throws DAOException;
    Product getProduct(int id) throws DAOException;
    List<String> getProductNameList() throws DAOException;
    List<Product> getProductList() throws DAOException;
}
