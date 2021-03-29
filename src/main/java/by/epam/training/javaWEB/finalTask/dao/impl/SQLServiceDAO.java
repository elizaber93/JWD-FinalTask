package by.epam.training.javaWEB.finalTask.dao.impl;

import by.epam.training.javaWEB.finalTask.bean.Rating;
import by.epam.training.javaWEB.finalTask.bean.Service;
import by.epam.training.javaWEB.finalTask.bean.builder.ServiceBuilder;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.dao.daoInterface.ServiceDAO;
import by.epam.training.javaWEB.finalTask.dao.executor.QueryExecutor;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLServiceDAO implements ServiceDAO {
    private final String INSERT_SERVICE = "insert into services (name, price, description) values (?, ?, ?);";
    private final String SELECT_BY_ID = "select * from services where idservice = ?;";
    private final String SELECT_BY_NAME = "select * from services where name = ?;";
    private final String SELECT_BY_PRICE = "select * from services where price >= ? and price <= ?;";
    private final String SELECT_BY_RATING = "select * from services where rating >= ?;";
    private final String SELECT_ALL = "select * from services;";
    private final String UPDATE_NAME = "update services set name = ? where idservice = ?;";
    private final String UPDATE_PRICE = "update services set price = ? where idservice = ?;";
    private final String UPDATE_RATING = "update services set total_rating = ? where idservice = ?;";
    private final String UPDATE_DESCRIPTION = "update services set description = ? where idservice = ?;";
    private final String DELETE_SERVICE = "delete from services where idservice = ?;";
    private final String SELECT_MAX_PRICE = "select max(price) from services;";
    private final String SELECT_MIN_PRICE = "select min(price) from services;";

    @Override
    public boolean addService(Service service) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        int result = executor.update(INSERT_SERVICE, service.getName(), service.getPrice(), service.getDescription());
        executor.close();
        return result == 1;
    }

    @Override
    public List<Service> getServiceList() throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = executor.select(SELECT_ALL);
        List<Service> serviceList = convertToList(resultSet);
        executor.close();
        return serviceList;
    }

    public List<Service> convertToList(ResultSet resultSet) {
        List<Service> serviceList = new ArrayList<>();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    serviceList.add(new ServiceBuilder().setId(resultSet.getInt(1))
                            .setName(resultSet.getString(2))
                            .setPrice(resultSet.getDouble(3))
                            .setDescription(resultSet.getString(4))
                            .setRating(resultSet.getInt(5))
                            .build());
                }
            } catch (SQLException e) {
                Logger.getLogger(SQLServiceDAO.class).info(e.getMessage());
            }
        }
        return serviceList;
    }

    public boolean deleteService(Service service) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        int result = executor.update(DELETE_SERVICE, service.getIdService());
        executor.close();
        return result == 1;
    }

    public boolean update(Parameter parameter, Service service, Object value) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        int result;
        switch (parameter) {
            case NAME:
                result = executor.update(UPDATE_NAME, value, service.getIdService());
                break;
            case PRICE:
                result = executor.update(UPDATE_PRICE, value, service.getIdService());
                break;
            case DESCRIPTION:
                result = executor.update(UPDATE_DESCRIPTION, value, service.getIdService());
                break;
            case RATING:
                result = executor.update(UPDATE_RATING, value, service.getIdService());
                break;
            default: result = 0;
        }
        executor.close();
        return result == 1;
    }

    public List<Service> getBy(Parameter parameter, Object ... value) throws DAOException {
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
        List<Service> serviceList = convertToList(resultSet);
        executor.close();
        return serviceList;
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
