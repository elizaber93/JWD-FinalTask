package by.epam.training.javaWEB.finalTask.dao.executor;

import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.dao.connection.ConnectionPool;
import by.epam.training.javaWEB.finalTask.dao.connection.ConnectionPoolException;
import by.epam.training.javaWEB.finalTask.dao.impl.SQLProductDAO;
import org.apache.log4j.Logger;

import java.sql.*;

public class QueryExecutor {
    private static QueryExecutor instance = new QueryExecutor();
    private PreparedStatement statement;
    private Connection connection;

    private QueryExecutor() {
    }

    public static QueryExecutor getInstance() {
        return instance;
    }
    private static ConnectionPool connectionPool;
    static {
        connectionPool = ConnectionPool.getInstance();
    }

    public PreparedStatement getPreparedStatement(String query) throws DAOException {
        try {
            this.connection = connectionPool.takeConnection();
        } catch (ConnectionPoolException e) {
            Logger.getLogger(QueryExecutor.class).info(e.getMessage());
            throw new DAOException("Failed to connect to database", e);
        }
        try {
            this.statement = connection.prepareStatement(query);
        } catch (SQLException e) {
            Logger.getLogger(QueryExecutor.class).info(e.getMessage());
            throw new DAOException("!!!WRITE SMTH",e);
        }
        return statement;
    }

    public void close() throws DAOException {

        assert connection != null;
        connectionPool.closeConnection(connection,statement);

    }

    public ResultSet select(String query, Object ... value) throws DAOException {
        PreparedStatement statement = getPreparedStatement(query);
        ResultSet resultSet = null;
        try {
            if (value.length != 0) {
                for (int i = 0; i < value.length; i++) {
                    if (value[i] instanceof Integer) {
                        statement.setInt(i+1, (int) value[i]);
                    } else if (value[i] instanceof String) {
                        statement.setString(i+1, (String) value[i]);
                    } else if (value[i] instanceof Double) {
                        statement.setDouble(i+1, (double) value[i]);
                    }
                }
            }
            resultSet = statement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            Logger.getLogger(QueryExecutor.class).info(e.getMessage());
            throw new DAOException("Failed statement execution in SQLDAO", e);
        }
    }

    public int update(String query, Object ... value) throws DAOException {
        PreparedStatement statement = getPreparedStatement(query);
        int result = 0;
        try {
            if (value.length != 0) {
                for (int i = 0; i < value.length; i++) {
                    if (value[i] instanceof Integer) {
                        statement.setInt(i + 1, (int) value[i]);
                    } else if (value[i] instanceof String) {
                        statement.setString(i + 1, (String) value[i]);
                    } else if (value[i] instanceof Double) {
                        statement.setDouble(i + 1, (double) value[i]);
                    } else if (value[i] instanceof Timestamp) {
                        statement.setTimestamp(i + 1, (Timestamp)value[i]);
                    }
                }

            }
            result = statement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(QueryExecutor.class).info(e.getMessage());
            throw new DAOException("Failed statement execution", e);
        }
        return result;
    }

}
