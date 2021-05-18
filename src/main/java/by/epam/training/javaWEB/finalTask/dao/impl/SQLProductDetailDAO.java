package by.epam.training.javaWEB.finalTask.dao.impl;

import by.epam.training.javaWEB.finalTask.bean.Product;
import by.epam.training.javaWEB.finalTask.bean.ProductDetail;
import by.epam.training.javaWEB.finalTask.bean.ProductProperty;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.dao.DAOProvider;
import by.epam.training.javaWEB.finalTask.dao.daoInterface.ProductDAO;
import by.epam.training.javaWEB.finalTask.dao.daoInterface.ProductDetailDAO;
import by.epam.training.javaWEB.finalTask.dao.executor.QueryExecutor;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLProductDetailDAO implements ProductDetailDAO {
    private final String SELECT_DETAILS = "select name,value from product_details join product_properties on product_properties.idproduct_properties = product_details.idproperty where idproduct = ?;";
    private final String CHECK_PROPERTY_NAME = "select count(*) from product_properties where name = ?;";
    private final String ADD_PROPERTY = "insert into product_properties (name) values (?);";
    private final String SELECT_ID = "select (idproduct_properties) from product_properties where name = ?;";
    private final String ADD_DETAIL = "insert into product_details (idproduct, idproperty, value) values (?,?,?);";
    private final String UPDATE_DETAIL = "update product_details set value = ? where idproduct = ? and idproperty = ?;";
    private final String SELECT_PROPERTIES = "select * from product_properties;";

    public boolean addDetail(Product product, String propertyName, String value) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        ProductDAO productDAO = DAOProvider.getInstance().getProductDAO();
        int result = 0;
        try {
            if (!checkProperty(propertyName)) {
                addNewProperty(propertyName);
            }
            result = executor.update(ADD_DETAIL, productDAO.getProductId(product.getName()), getPropertyId(propertyName), value);
        } catch (DAOException e) {
            throw new DAOException(e);
        } finally {
            executor.close();
        }
        return result >= 1;
    }


    @Override
    public List<ProductDetail> getProductDetailList(int id) throws DAOException {
        List<ProductDetail> detailList = new ArrayList<>();
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = executor.select(SELECT_DETAILS, id);
        try {
            while (resultSet.next()) {
                detailList.add(new ProductDetail(resultSet.getString(1),resultSet.getString(2)));
            }
        } catch (SQLException e) {
            throw new DAOException("Failed in getting data from product_details", e);
        } finally {
            executor.close();
        }
        return detailList;
    }

    public boolean updateDetail(Product product,String propertyName,String value) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        int result = 0;
        try {
            result = executor.update(UPDATE_DETAIL, value, product.getIdProduct(), getPropertyId(propertyName));
        } catch (DAOException e) {
            throw new DAOException(e);
        } finally {
            executor.close();
        }
        return result >= 1;
    }

    public int getPropertyId(String propertyName) throws DAOException {
        int idProperty = 0;
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = null;
        try {
            resultSet = executor.select(SELECT_ID, propertyName);
            if (resultSet.next()) {
                idProperty = resultSet.getInt(1);
            }
        } catch (SQLException | DAOException e) {
           throw new DAOException("Failed in getting property id", e);
        } finally {
            executor.close();
        }
        return idProperty;
    }

    @Override
    public List<ProductProperty> getPropertyList() throws DAOException {
        List<ProductProperty> propertyList = new ArrayList<>();
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = null;
        try {
            resultSet = executor.select(SELECT_PROPERTIES);
            while (resultSet.next()) {
                propertyList.add(new ProductProperty(resultSet.getInt(1),resultSet.getString(2)));
            }
        } catch (SQLException e) {
            throw new DAOException("Failed in getting data from product_properties", e);
        } finally {
            executor.close();
        }
        return propertyList;
    }

    boolean addNewProperty(String name) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        int result = 0;
        try {
            result = executor.update(ADD_PROPERTY, name);
        } catch (DAOException e) {
            throw new DAOException(e);
        } finally {
            executor.close();
        }
        return result >= 1;
    }

    boolean checkProperty(String name) throws DAOException{
        QueryExecutor executor = QueryExecutor.getInstance();
        int result = 0;
        try {
            ResultSet resultSet = executor.select(CHECK_PROPERTY_NAME, name);
            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }
        } catch (DAOException | SQLException e) {
            throw new DAOException(e);
        } finally {
            executor.close();
        }
        return result != 0;
    }


}
