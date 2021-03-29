package by.epam.training.javaWEB.finalTask.dao.impl;

import by.epam.training.javaWEB.finalTask.bean.Product;
import by.epam.training.javaWEB.finalTask.bean.Service;
import by.epam.training.javaWEB.finalTask.bean.builder.ProductBuilder;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.dao.daoInterface.ProductDAO;
import by.epam.training.javaWEB.finalTask.dao.executor.QueryExecutor;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLProductDAO implements ProductDAO {
    private final String INSERT_PRODUCT = "insert into products (name, description, image) values (?,?,?);";
    private final String SELECT_PRODUCT_LIST = "select * from products;";
    private final String SELECT_BY_ID = "select * from products where idproduct = ?;";
    private final String SELECT_BY_PRICE = "select * from products where current_price >= ? and current_price <= ?;";
    private final String SELECT_BY_RATING = "select * from products where rating >= ?;";
    private final String SELECT_BY_NAME = "select * from products where name = ?;";
    private final String UPDATE_ALL = "update products set name = ?, " +
                                        "current_price = ?, " +
                                        "current_quantity = ?, " +
                                        "description = ?, " +
                                        "total_rating = ?, " +
                                        "total_quantity = ?, " +
                                        "image = ? where idproduct = ?;";
    private final String UPDATE_NAME = "update products set name = ? where idproduct = ?;";
    private final String UPDATE_PRICE = "update products set current_price = ? where idproduct = ?;";
    private final String UPDATE_QUANTITY = "update products set current_quantity = ? where idproduct = ?;";
    private final String UPDATE_DESCRIPTION = "update products set description = ? where idproduct = ?;";
    private final String UPDATE_RATING = "update products set total_rating = ? where idproduct = ?;";
    private final String UPDATE_TOTAL_QUANITY = "update products set total_quantity = ? where idproduct = ?;";
    private final String UPDATE_IMAGE = "update products set image = ? where idproduct = ?;";
    private final String CHECK_NAME = "select count(*) from products where name = ?;";
    private final String SELECT_MAX_PRICE = "select max(price) from products;";
    private final String SELECT_MIN_PRICE = "select min(price) from products;";

    @Override
    public boolean addProduct(Product product) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        int result = executor.update(SELECT_BY_ID, product.getName(), product.getDescription(), product.getImageLink());
        executor.close();
        return result == 1;
    }

    @Override
    public Product getProduct(int id) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = executor.select(SELECT_BY_ID, id);
        Product product = convertToList(resultSet).get(0);
        executor.close();
        return product;
    }

    @Override
    public List<String> getProductNameList() throws DAOException {
        List<String> productList = new ArrayList<>();
        List<Product> products = getProductList();
        for (Product product : products) {
            productList.add(product.getName());
        }
        return productList;
    }

    @Override
    public List<Product> getProductList() throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = executor.select(SELECT_PRODUCT_LIST);
        List<Product> productList = convertToList(resultSet);
        executor.close();
        return productList;
    }

    public List<Product> convertToList(ResultSet resultSet) throws DAOException {
        List<Product> productList = new ArrayList<>();
        if (resultSet != null) {
            try {
                while(resultSet.next()) {
                    Product product = new ProductBuilder()
                            .setProductId(resultSet.getInt(1))
                            .setName(resultSet.getString(2))
                            .setCurrentPrice(resultSet.getDouble(3))
                            .setCurrentQuantity(resultSet.getInt(4))
                            .setDescription(resultSet.getString(5))
                            .setImageLink(resultSet.getString(6))
                            .setTotalRating(resultSet.getInt(7))
                            .setTotalQuantity(resultSet.getInt(8))
                            .build();
                    product.setDetails(new SQLProductDetailDAO().getProductDetailList(product.getIdProduct()));
                    productList.add(product);
                }
            } catch (SQLException e) {
                Logger.getLogger(SQLProductDAO.class).info(e.getMessage());
            }
        }
        return productList;
    }

    public List<Product> getBy(Parameter parameter, Object ... value) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = null;
        switch (parameter) {
            case NAME:
                resultSet = executor.select(SELECT_BY_NAME, value);
                break;
            case PRICE:
                if (value.length == 0) {
                    resultSet = executor.select(SELECT_BY_PRICE, getMinPrice(), getMaxPrice());
                } else if (value.length == 1) {
                    resultSet = executor.select(SELECT_BY_PRICE, getMinPrice(), value[0]);
                } else {
                    resultSet = executor.select(SELECT_BY_PRICE, value[0], value[1]);
                }
                break;
            case ID:
                resultSet = executor.select(SELECT_BY_ID, value);
                break;
            case RATING:
                resultSet = executor.select(SELECT_BY_RATING, value);
                break;
        }
        List<Product> productList = convertToList(resultSet);
        executor.close();
        return productList;
    }

    public double getMinPrice() throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = executor.select(SELECT_MIN_PRICE);
        double result = 0.;
        try {
            result = resultSet.getDouble(1);
        } catch (SQLException e) {
            //Logger
            throw new DAOException("Failed in getting min price");
        } finally {
            executor.close();
        }
        return result;
    }

    public double getMaxPrice() throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = executor.select(SELECT_MAX_PRICE);
        double result = 0.;
        try {
            result = resultSet.getDouble(1);
        } catch (SQLException e) {
            //Logger
            throw new DAOException("Failed in getting min price");
        } finally {
            executor.close();
        }
        return result;
    }
}
