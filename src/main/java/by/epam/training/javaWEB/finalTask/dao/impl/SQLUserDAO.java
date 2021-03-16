package by.epam.training.javaWEB.finalTask.dao.impl;

import by.epam.training.javaWEB.finalTask.bean.RegistrationInfo;
import by.epam.training.javaWEB.finalTask.bean.User;
import by.epam.training.javaWEB.finalTask.connection.ConnectionPool;
import by.epam.training.javaWEB.finalTask.connection.ConnectionPoolException;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.dao.UserDAO;
import by.epam.training.javaWEB.finalTask.service.ServiceException;
import by.epam.training.javaWEB.finalTask.service.ServiceProvider;
import by.epam.training.javaWEB.finalTask.service.impl.UserServiceImpl;

import javax.sql.rowset.serial.SerialException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLUserDAO implements UserDAO {
    private static ConnectionPool connectionPool;
    static {
        connectionPool = ConnectionPool.getInstance();
    }

    @Override
    public User authorization(String login, String password) throws DAOException {


        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
        } catch (ConnectionPoolException e) {
            //logger
        }

        Statement statement = null;
        try {
            assert connection != null;
            statement = connection.createStatement();
        } catch (SQLException e) {
            //logger
        }

        String userQuery = "select * from users";
        ResultSet resultSet = null;
        try {
            assert statement != null;
            resultSet = statement.executeQuery(userQuery);
        } catch (SQLException e) {
            throw new DAOException("невозможно выполнить sql-запрос", e);
            //logger
        }
        try{
            while (resultSet.next()) {
                if (resultSet.getString("login").equals(login) &&
                        resultSet.getString("password").equals(password)) {
                    return new User(login, password, resultSet.getInt("idrole"));
                }
                if (resultSet.getString("login").equals(login) &&
                        !resultSet.getString("password").equals(password)) {
                    throw new DAOException("неверный пароль");
                }
                if (!resultSet.getString("login").equals(login) ||
                        !resultSet.getString("password").equals(password)) {
                    throw new DAOException("неверный логин или пароль");
                }
            }
        } catch (SQLException e) {
            //logger
        }
        throw new DAOException("User not found");
    }

    @Override
    public boolean registration(RegistrationInfo regInfo) throws DAOException {
        if (findUser(regInfo.getLogin())) {
            throw new DAOException("Пользователь с таким логином уже существует");
        }
        try {
            ServiceProvider.getInstance().getValidationService().isValid(regInfo);
        } catch (ServiceException e) {
            throw new DAOException("неверная регистрационная информация");
        }
        String insertUserQuery = "insert into users(login, password) values (\"" + regInfo.getLogin() + "\",\"" +regInfo.getPassword() + "\");";

        String getUserIdQuery = "select iduser from users where login = \"" + regInfo.getLogin() + "\";";

        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
        } catch (ConnectionPoolException e) {
            //logger
        }

        Statement statement = null;
        try {
            assert connection != null;
            statement = connection.createStatement();
        } catch (SQLException e) {
            //logger
        }



        int updateResult;
        try {
            assert statement != null;
            updateResult = statement.executeUpdate(insertUserQuery);
        } catch (SQLException e) {
            throw new DAOException("невозможно выполнить sql-запрос", e);
            //logger
        }
        if (updateResult != 1) {
            System.out.println("Данные не добавлены");
            return false;
        }
        return true;
    }

    public boolean findUser(String login) {
        return false;
    }
}
