package by.epam.training.javaWEB.finalTask.dao.impl;

import by.epam.training.javaWEB.finalTask.bean.Product;
import by.epam.training.javaWEB.finalTask.bean.ProductDetail;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
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
    private final String SELECT_ID = "select idproduct_properties from product_properties where name = ?;";
    private final String ADD_DETAIL = "insert into product_details (idproduct, idproperty, value) values (?,?,?);";
    private final String UPDATE_DETAIL = "update product_details set value = ? where idproduct = ? and idproperty = ?;";

    public boolean addDetail(Product product, String propertyName, String value) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = executor.select(CHECK_PROPERTY_NAME, propertyName);
        try {
            if (resultSet.getInt(1) == 0) {
                if (executor.update(ADD_PROPERTY,propertyName) != 1) {
                    throw  new DAOException("Failed in adding new property");
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(SQLProductDetailDAO.class).info("Failed in adding new property");
            throw new DAOException(e);
        }
        int result = executor.update(ADD_DETAIL, product.getIdProduct(), getPropertyId(propertyName), value);
        executor.close();
        return result == 1;
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
            Logger.getLogger(SQLProductDetailDAO.class).info(e.getMessage());
            throw new DAOException("Failed in getting data from product_details", e);
        }
        return detailList;
    }

    public boolean updateDetail(Product product,String propertyName,String value) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        int result = executor.update(UPDATE_DETAIL, value, product.getIdProduct(), getPropertyId(propertyName));
        executor.close();
        return result == 1;
    }

    public int getPropertyId(String propertyName) throws DAOException {
        int idProperty = 0;
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = executor.select(SELECT_ID, propertyName);
        try {
            idProperty = resultSet.getInt(1);
        } catch (SQLException e) {
            Logger.getLogger(SQLProductDetailDAO.class).info(e.getMessage());
            throw new DAOException("Failed in getting property id", e);
        }
        return idProperty;
    }
}
