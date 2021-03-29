package by.epam.training.javaWEB.finalTask.dao.impl;

import by.epam.training.javaWEB.finalTask.bean.Supply;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.dao.daoInterface.SupplyDAO;
import by.epam.training.javaWEB.finalTask.dao.executor.QueryExecutor;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLSupplyDAO implements SupplyDAO {
    private final String INSERT_SUPPLY = "inset into supplies (idproduct, idsupplier, document, date," +
                                        "manufacturer_price, discount_price, quantity) values (?,?,?,?,?,?,?);";
    private final String SELECT_QUANTITY = "select (quantity) from supplies where idproduct = ?;";



    @Override
    public boolean addSupply(Supply supply) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        PreparedStatement statement = executor.getPreparedStatement(INSERT_SUPPLY);
        int result;
        try {
            statement.setInt(1, supply.getIdProduct());
            statement.setInt(2, supply.getSupplierId());
            statement.setString(3,supply.getDocument());
            statement.setTimestamp(4,supply.getDate());
            statement.setDouble(5, supply.getManufacturerPrice());
            statement.setDouble(6,supply.getDiscountPrice());
            statement.setInt(7, supply.getQuantity());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(SQLSupplyDAO.class).info(e.getMessage());
            throw new DAOException("Failed execution statement", e);
        } finally {
            executor.close();
        }
        return result >= 1;
    }

    public int getLastQuantity(int productId) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        PreparedStatement statement = executor.getPreparedStatement(SELECT_QUANTITY);
        ResultSet resultSet = null;
        int result;
        try {
            statement.setInt(1, productId);
            resultSet = statement.executeQuery();
            resultSet.last();
            result = resultSet.getInt(1);
        } catch (SQLException e) {
            Logger.getLogger(SQLSupplyDAO.class).info(e.getMessage());
            throw new DAOException("Failed execution statement", e);
        } finally {
            executor.close();
        }
        return result;
    }
}
