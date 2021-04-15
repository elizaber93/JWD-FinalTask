package by.epam.training.javaWEB.finalTask.dao.daoInterface;

import by.epam.training.javaWEB.finalTask.bean.Product;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.dao.impl.Parameter;

import java.util.List;

public interface ProductDAO {
    boolean addProduct(Product product) throws DAOException;
    boolean deleteProduct(Product product) throws DAOException;
    boolean update(Parameter parameter, Product product, Object value) throws DAOException;
    List<Product> getBy(Parameter parameter, Object ... value) throws DAOException;
    List<Product> getProductList() throws DAOException;
    boolean check(int id) throws DAOException;
    boolean check(String name) throws DAOException;

}
