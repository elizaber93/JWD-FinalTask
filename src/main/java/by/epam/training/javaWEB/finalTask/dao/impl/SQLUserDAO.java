package by.epam.training.javaWEB.finalTask.dao.impl;

import by.epam.training.javaWEB.finalTask.bean.RegistrationInfo;
import by.epam.training.javaWEB.finalTask.bean.Role;
import by.epam.training.javaWEB.finalTask.bean.User;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.service.exception.InvalidLoginException;
import by.epam.training.javaWEB.finalTask.service.exception.InvalidPasswordException;
import by.epam.training.javaWEB.finalTask.dao.daoInterface.UserDAO;
import by.epam.training.javaWEB.finalTask.dao.executor.QueryExecutor;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUserDAO implements UserDAO {

    private final String FIND_USER_BY_LOGIN_N_PASSWORD = "select * from users where login = ? and password = ?;";
    private final String INSERT_USER = "insert into users (login,password,idrole) values (?,?,?);";
    private final String COUNT_LOGIN = "select count(*) from users where login = ?;";
    private final String COUNT_LOGIN_N_PASSWORD = "select count(*) from users where login = ? and password = ?;";
    private final String SELECT_USER_ID = "select (iduser) from users where login = ?;";

    @Override
    public User authorization(String login, String password) throws DAOException {
        if (!isFoundByLogin(login)) {
            throw new InvalidLoginException("Login not found");
        }
        if (!findByLoginAndPassword(login, password)) {
            throw new InvalidPasswordException("Illegal password");
        }
        return selectUserByLoginAndPassword(login, password);
    }

    @Override
    public boolean registration(RegistrationInfo regInfo) throws DAOException {
        if (isFoundByLogin(regInfo.getLogin())) {
            throw new InvalidLoginException("Login is already taken");
        }
        return insertUser(regInfo.getLogin(), regInfo.getPassword(), Role.CLIENT.getIdRole());

    }

    public boolean isFoundByLogin(String login) throws DAOException {

        QueryExecutor executor = QueryExecutor.getInstance();
        PreparedStatement statement = executor.getPreparedStatement(COUNT_LOGIN);

        ResultSet foundUserCount = null;
        int result;
        try {
            statement.setString(1, login);
            foundUserCount = statement.executeQuery();
            foundUserCount.next();
            result = foundUserCount.getInt(1);
        } catch (SQLException e) {
            Logger.getLogger(SQLUserDAO.class).info(e.getMessage());
            throw new DAOException("Failed execution statement", e);
        } finally {
            executor.close();
        }
        return result >= 1;
    }

    public boolean findByLoginAndPassword(String login, String password) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        PreparedStatement statement = executor.getPreparedStatement(COUNT_LOGIN_N_PASSWORD);

        ResultSet resultSet = null;
        int result;
        try {
            statement.setString(1, login);
            statement.setString(1, password);
            resultSet = statement.executeQuery();
            resultSet.next();
            result = resultSet.getInt(1);
        } catch (SQLException e) {
            Logger.getLogger(SQLUserDAO.class).info(e.getMessage());
            throw new DAOException("Failed execution statement", e);
        } finally {
            executor.close();
        }
        return result >= 1;
    }

    public User selectUserByLoginAndPassword(String login, String password) throws DAOException {
        User user = new User();
        QueryExecutor executor = QueryExecutor.getInstance();

        PreparedStatement statement = executor.getPreparedStatement(FIND_USER_BY_LOGIN_N_PASSWORD);

        ResultSet foundUser = null;
        try {
            statement.setString(1, login);
            statement.setString(2, password);
            foundUser = statement.executeQuery();
        } catch (SQLException e) {
            Logger.getLogger(SQLUserDAO.class).info(e.getMessage());
            throw new DAOException("Failed execution statement", e);
        } finally {
            executor.close();
        }
        try {
            if (foundUser.next()) {
                user.setId(foundUser.getLong(1));
                user.setRole(foundUser.getInt(4));
                user.setLogin(login);
                user.setPassword(password);
            }
        } catch (SQLException e) {
            Logger.getLogger(SQLUserDAO.class).info(e.getMessage());
            throw new DAOException("User not found", e);
        }
        return user;
    }

    public boolean insertUser(String login, String password, int idrole) throws DAOException {

        QueryExecutor executor = QueryExecutor.getInstance();
        PreparedStatement statement = executor.getPreparedStatement(INSERT_USER);
        int result;
        try {
            statement.setString(1,login);
            statement.setString(2, password);
            statement.setInt(3,2);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(SQLUserDAO.class).info(e.getMessage());
            throw new DAOException("Failed to add user",e);
        }
        return result >= 1;
    }

    public long getUserId(String login) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        PreparedStatement statement = executor.getPreparedStatement(SELECT_USER_ID);
        ResultSet foundUser = null;
        int userId;
        try {
            statement.setString(1, login);
            foundUser = statement.executeQuery();
            foundUser.next();
            userId = foundUser.getInt(1);
        } catch (SQLException e) {
            Logger.getLogger(SQLUserDAO.class).info(e.getMessage());
            throw new DAOException("Failed execution statement", e);
        } finally {
            executor.close();
        }
        return userId;
    }
}
