package by.epam.training.javaWEB.finalTask.dao.impl;

import by.epam.training.javaWEB.finalTask.bean.Service;
import by.epam.training.javaWEB.finalTask.bean.builder.ServiceBuilder;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.dao.daoInterface.EnumDAO;
import by.epam.training.javaWEB.finalTask.dao.executor.QueryExecutor;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLEnumDAO implements EnumDAO {
    private final String SELECT_ROLES = "select * from roles;";
    private final String SELECT_STATUSES = "select * from status;";
    private final String SELECT_CATEGORIES = "select * from categories;";
    private final String SELECT_PAYMENT_METHODS = "select * from payments_methods;";
    private final String SELECT_DELIVERY_METHODS = "select * from delivery_methods;";

    @Override
    public Map<Integer, String> getRoles() throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = null;
        Map<Integer, String> roles = null;
        try {
            resultSet = executor.select(SELECT_ROLES);
            roles = convertToMap(resultSet);
        } catch (DAOException e) {
            throw new DAOException(e);
        } finally {
            executor.close();
        }
        return roles;
    }

    @Override
    public Map<Integer, String> getCategories() throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = null;
        Map<Integer, String> categories = null;
        try {
            resultSet = executor.select(SELECT_CATEGORIES);
            categories = convertToMap(resultSet);
        } catch (DAOException e) {
            throw new DAOException(e);
        } finally {
            executor.close();
        }
        return categories;
    }

    @Override
    public Map<Integer, String> getStatuses() throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = null;
        Map<Integer, String> statuses = null;
        try {
            resultSet = executor.select(SELECT_STATUSES);
            statuses = convertToMap(resultSet);
        } catch (DAOException e) {
            throw new DAOException(e);
        } finally {
            executor.close();
        }
        return statuses;
    }

    @Override
    public Map<Integer, String> getDeliveryMethods() throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = null;
        Map<Integer, String> deliveryMethods = null;
        try {
            resultSet = executor.select(SELECT_DELIVERY_METHODS);
            deliveryMethods = convertToMap(resultSet);
        } catch (DAOException e) {
            throw new DAOException(e);
        } finally {
            executor.close();
        }
        return deliveryMethods;
    }

    @Override
    public Map<Integer, String> getPaymentMethods() throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = null;
        Map<Integer, String> paymentMethods = null;
        try {
            resultSet = executor.select(SELECT_PAYMENT_METHODS);
            paymentMethods = convertToMap(resultSet);
        } catch (DAOException e) {
            throw new DAOException(e);
        } finally {
            executor.close();
        }
        return paymentMethods;
    }

    public Map<Integer, String> convertToMap(ResultSet resultSet) {
        Map<Integer,String> items = new HashMap<>();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    items.put(resultSet.getInt(1), resultSet.getString(2));
                }
            } catch (SQLException e) {
                Logger.getLogger(SQLServiceDAO.class).info(e.getMessage());
            }
        }
        return items;
    }

}
