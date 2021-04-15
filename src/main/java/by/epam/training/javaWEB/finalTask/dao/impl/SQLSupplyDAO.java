package by.epam.training.javaWEB.finalTask.dao.impl;

import by.epam.training.javaWEB.finalTask.bean.Supply;
import by.epam.training.javaWEB.finalTask.bean.builder.SupplyBuilder;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.dao.daoInterface.SupplyDAO;
import by.epam.training.javaWEB.finalTask.dao.executor.QueryExecutor;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLSupplyDAO implements SupplyDAO {
    private final String INSERT_SUPPLY = "inset into supplies (idproduct, idsupplier, document, date," +
                                        "manufacturer_price, discount_price, quantity) values (?,?,?,?,?,?,?);";
    private final String SELECT_QUANTITY = "select (quantity) from supplies where idproduct = ?;";
    private final String DELETE_SUPPLY = "delete from supplies where idsupply = ?";
    private final String SELECT_BY_SUPPLIER_NAME = "select * from supplies join suppliers on supplies.idsupplier = suppliers.idsupplier where suppliers.name = ?;";
    private final String SELECT_BY_PRODUCT_NAME = "select * from supplies join products on supplies.idproduct = product.idproduct where product.name = ?;";
    private final String SELECT_BY_PRODUCT_ID = "select * from supplies where idproduct = ?;";
    private final String SELECT_BY_SUPPLIER_ID = "select * from supplies where idsupplier = ?;";
    private final String SELECT_BY_DATE = "select * from supplies where date = ?;";
    private final String SELECT_BY_DOCUMENT = "select * from supplies where document = ?;";
    private final String SELECT_ALL = "select * from supplies;";



    @Override
    public boolean addSupply(Supply supply) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        int result = executor.update(INSERT_SUPPLY,
                supply.getIdProduct(),
                supply.getSupplierId(),
                supply.getDocument(),
                supply.getDate(),
                supply.getManufacturerPrice(),
                supply.getDiscountPrice(),
                supply.getQuantity()
                );
        executor.close();
        return result == 1;
    }

    public boolean deleteSupply(Supply supply) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        int result = executor.update(DELETE_SUPPLY, supply.getIdSupply());
        executor.close();
        return result == 1;
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

    public List<Supply> getBy(Parameter parameter, Object value) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = null;
        switch (parameter) {
            case PRODUCT_NAME:
                resultSet = executor.select(SELECT_BY_PRODUCT_NAME, value);
                break;
            case PRODUCT_ID:
                resultSet = executor.select(SELECT_BY_PRODUCT_ID, value);
                break;
            case SUPPLIER_NAME:
                resultSet = executor.select(SELECT_BY_SUPPLIER_NAME, value);
                break;
            case SUPPLIER_ID:
                resultSet = executor.select(SELECT_BY_SUPPLIER_ID, value);
                break;
            case DOCUMENT:
                resultSet = executor.select(SELECT_BY_DOCUMENT, value);
                break;
            case DATE:
                resultSet = executor.select(SELECT_BY_DATE, value);
                break;
            default:
                resultSet = executor.select(SELECT_ALL);
                break;
        }
        List<Supply> supplyList = convertToList(resultSet);
        executor.close();
        return supplyList;
    }

    public List<Supply> convertToList(ResultSet resultSet) {
        List<Supply> supplyList = new ArrayList<>();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    supplyList.add(new SupplyBuilder()
                            .setId(resultSet.getInt(1))
                            .setProductId(resultSet.getInt(2))
                            .setSupplierID(resultSet.getInt(3))
                            .setDocument(resultSet.getString(4))
                            .setDate(resultSet.getTimestamp(5))
                            .setManufacturerPrice(resultSet.getDouble(6))
                            .setDiscountPrice(resultSet.getDouble(7))
                            .setQuantity(resultSet.getInt(8))
                            .build());
                }
            } catch (SQLException e) {
                Logger.getLogger(SQLSupplyDAO.class).info(e.getMessage());
            }
        }
        return supplyList;
    }
}
