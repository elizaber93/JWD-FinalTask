package by.epam.training.javaWEB.finalTask.dao.impl;

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
    private final String INSERT_SERVICE = "insert into services (name, price, description, idcategory) values (?, ?, ?, (select idcategory from categories where name = ?));";
    private final String SELECT_BY_ID = "select * from services where idservice = ?;";
    private final String SELECT_BY_NAME = "select * from services where name = ?;";
    private final String SELECT_BY_PRICE = "select * from services where price >= ? and price <= ?;";
    private final String SELECT_BY_RATING = "select idservice, services.name, price, description, total_rating, categories.name from services join categories on services.idcategory = categories.idcategory where rating >= ?;";
    private final String SELECT_ALL = "select idservice, services.name, price, description, total_rating, categories.name, status.name from services join categories on services.idcategory = categories.idcategory join status on services.status = status.idstatus;";
    private final String UPDATE_NAME = "update services set name = ? where idservice = ?;";
    private final String UPDATE_PRICE = "update services set price = ? where idservice = ?;";
    private final String UPDATE_CATEGORY = "update services set idcategory = (select idcategory from categories where name = ?) where idservice = ?;";
    private final String UPDATE_STATUS = "update services set status = (select idstatus from status where name = ?) where idservice = ?;";
    private final String UPDATE_RATING = "update services set total_rating = ? where idservice = ?;";
    private final String UPDATE_DESCRIPTION = "update services set description = ? where idservice = ?;";
    private final String DELETE_SERVICE = "delete from services where idservice = ?;";
    private final String SELECT_MAX_PRICE = "select max(price) from services;";
    private final String SELECT_MIN_PRICE = "select min(price) from services;";
    private final String CHECK_ID = "select count(*) from services where idservice = ?;";
    private final String CHECK_NAME = "select count(*) from services where name = ?;";

    @Override
    public boolean addService(Service service) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        int result = 0;
        try{
            result = executor.update(INSERT_SERVICE, service.getName(), service.getPrice(), service.getDescription(), service.getCategory());
        } catch (DAOException e) {
            throw new DAOException(e);
        } finally {
            executor.close();
        }
        return result >= 1;
    }

    @Override
    public List<Service> getServiceList() throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = null;
        List<Service> serviceList = null;
        try {
            resultSet = executor.select(SELECT_ALL);
            serviceList = convertToList(resultSet);
        } catch (DAOException e) {
            throw new DAOException(e);
        } finally {
            executor.close();
        }
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
                            .setCategory(resultSet.getString(6))
                            .setStatus(resultSet.getString(7))
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
        int result = 0;
        try {
            result = executor.update(DELETE_SERVICE, service.getIdService());
        } catch (DAOException e) {
            throw new DAOException(e);
        } finally {
            executor.close();
        }
        return result >= 1;
    }

    public boolean update(Parameter parameter, int serviceId, Object value) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        int result;
        try {
            switch (parameter) {
                case NAME:
                    result = executor.update(UPDATE_NAME, value, serviceId);
                    break;
                case PRICE:
                    result = executor.update(UPDATE_PRICE, value, serviceId);
                    break;
                case DESCRIPTION:
                    result = executor.update(UPDATE_DESCRIPTION, value, serviceId);
                    break;
                case RATING:
                    result = executor.update(UPDATE_RATING, value, serviceId);
                    break;
                case CATEGORY:
                    result = executor.update(UPDATE_CATEGORY, value, serviceId);
                    break;
                case STATUS:
                    result = executor.update(UPDATE_STATUS, value, serviceId);
                    break;
                default:
                    result = 0;
            }
        } catch (DAOException e) {
            throw new DAOException(e);
        } finally {
            executor.close();
        }
        return result >= 1;
    }

    public List<Service> getBy(Parameter parameter, Object ... value) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = null;
        List<Service> serviceList = null;
        try {
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
            serviceList = convertToList(resultSet);
        } catch (DAOException e) {
            throw new DAOException(e);
        } finally {
            executor.close();
        }
        return serviceList;
    }

    public double getMinPrice() throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = executor.select(SELECT_MIN_PRICE);
        double result = 0.;
        try {
            result = resultSet.getDouble(1);
        } catch (SQLException e) {
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
            throw new DAOException("Failed in getting min price");
        } finally {
            executor.close();
        }
        return result;
    }
}
