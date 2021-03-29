package by.epam.training.javaWEB.finalTask.dao.impl;

import by.epam.training.javaWEB.finalTask.bean.Supplier;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.dao.daoInterface.SupplierDAO;
import by.epam.training.javaWEB.finalTask.dao.executor.QueryExecutor;
import org.apache.log4j.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLSupplierDAO implements SupplierDAO {
    private final String INSERT_SUPPLIER = "insert into suppliers (name, requisites) values (?,?);";
    private final String CHECK_BY_NAME = "select count(*) from suppliers where name = ?;";
    private final String CHECK_BY_ID = "select count(*) from suppliers where idsupplier = ?;";
    private final String SELECT_ALL = "select * from suppliers;";
    private final String SELECT_BY_ID = "select * from suppliers where idsupplier = ?;";
    private final String SELECT_BY_NAME = "select * from suppliers where supplier = ?;";
    private final String SELECT_BY_REQUISITES = "select * from suppliers where requisites = ?;";
    private final String UPDATE_NAME = "update suppliers set name = ? where idsupplier = ?;";
    private final String UPDATE_REQUISITES = "update suppliers set requisites = ? where idsupplier = ?;";
    private final String DELETE_SUPPLIER = "delete from suppliers where idsupplier = ?;";

    @Override
    public boolean addSupplier(Supplier supplier) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        int result = executor.update(INSERT_SUPPLIER, supplier.getName(), supplier.getRequisites());
        executor.close();
        return result == 1;
    }

    @Override
    public boolean deleteSupplier(Supplier supplier) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        int result = executor.update(DELETE_SUPPLIER, supplier.getIdSupplier());
        executor.close();
        return result == 1;
    }

    public List<Supplier> getBy(Parameter parameter, Object... value) throws DAOException {
        if (value.length != 1) {
            throw new DAOException("Illegal count of parameters");
        }
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = null;
        switch (parameter) {
            case NAME:
                resultSet = executor.select(SELECT_BY_NAME, value);
                System.out.println("i'm in namecase");
                break;
            case REQUISITES:
                resultSet = executor.select(SELECT_BY_REQUISITES, value);
                break;
            case ID:
                resultSet = executor.select(SELECT_BY_ID, value);
                break;
            default:
                resultSet = executor.select(SELECT_ALL);
                break;
        }
        List<Supplier> supplierList = convertToList(resultSet);
        executor.close();
        return supplierList;
    }

    public List<Supplier> convertToList(ResultSet resultSet) {
        List<Supplier> supplierList = new ArrayList<>();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    supplierList.add(new Supplier(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3)));
                }
            } catch (SQLException e) {
                Logger.getLogger(SQLServiceDAO.class).info(e.getMessage());
            }
        }
        return supplierList;
    }


    public boolean check(String name) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = executor.select(CHECK_BY_NAME, name);
        int result;
        try {
            result = resultSet.getInt(1);
        } catch (SQLException e) {
            throw new DAOException("failed in checking supplier by name", e);
        }
        return result >= 1;
    }

    public boolean check(int id) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = executor.select(CHECK_BY_ID, id);
        int result;
        try {
            result = resultSet.getInt(1);
        } catch (SQLException e) {
            throw new DAOException("failed in checking supplier by id", e);
        }
        return result >= 1;
    }

    @Override
    public List<Supplier> getSupplierList() throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = executor.select(SELECT_ALL);
        List<Supplier> supplierList = convertToList(resultSet);
        executor.close();
        return supplierList;
    }

    public boolean update(Parameter parameter, Supplier supplier, Object value) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        int result;
        switch (parameter) {
            case NAME:
                result = executor.update(UPDATE_NAME, value, supplier.getIdSupplier());
                break;
            case REQUISITES:
                result = executor.update(UPDATE_REQUISITES, value, supplier.getIdSupplier());
                break;
            default: result = 0;
        }
        executor.close();
        return result == 1;
    }
}
