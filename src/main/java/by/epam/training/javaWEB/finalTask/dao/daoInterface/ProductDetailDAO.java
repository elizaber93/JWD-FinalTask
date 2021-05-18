package by.epam.training.javaWEB.finalTask.dao.daoInterface;

import by.epam.training.javaWEB.finalTask.bean.Product;
import by.epam.training.javaWEB.finalTask.bean.ProductDetail;
import by.epam.training.javaWEB.finalTask.bean.ProductProperty;
import by.epam.training.javaWEB.finalTask.dao.DAOException;

import java.util.List;

public interface ProductDetailDAO {

    List<ProductDetail> getProductDetailList(int id) throws DAOException;
    List<ProductProperty> getPropertyList() throws DAOException;
    int getPropertyId(String propertyName) throws DAOException;
    boolean updateDetail(Product product,String propertyName,String value) throws DAOException;
    boolean addDetail(Product product, String propertyName, String value) throws DAOException;
}
