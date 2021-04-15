package by.epam.training.javaWEB.finalTask.dao.impl;

import by.epam.training.javaWEB.finalTask.bean.*;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.dao.daoInterface.UserDAO;
import by.epam.training.javaWEB.finalTask.dao.daoInterface.UserDetailDAO;
import by.epam.training.javaWEB.finalTask.dao.executor.QueryExecutor;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLUserDAO implements UserDAO {

    private final String SELECT_BY_LOGIN_N_PASSWORD = "select * from users where login = ? and password = ?;";
    private final String INSERT_USER = "insert into users (login,password,idrole,idstatus) values (?,?,?,?);";
    private final String CHECK_BY_LOGIN = "select count(*) from users where login = ?;";
    private final String CHECK_BY_LOGIN_N_PASSWORD = "select count(*) from users where login = ? and password = ?;";
    private final String SELECT_ID_BY_LOGIN = "select (iduser) from users where login = ?;";
    private final String UPDATE_STATUS = "update users set idstatus = ?;";
    private final String UPDATE_ROLE = "update users set idrole = ?;";
    private final String UPDATE_PASSWORD = "update users set password = ?;";
    private final String DELETE_LOGIN = "update users set login = NULL where iduser = ?;";
    private final String DELETE_PASSWORD = "update users set password = NULL where iduser = ?;";
    private final String SELECT_BY_LOGIN = "select * from users where login = ?;";
    private final String SELECT_ALL = "select * from users;";
    private final String SELECT_BY_ROLE = "select * from users where idrole = ?;";
    private final String SELECT_BY_STATUS = "select * from users where idstatus = ?;";
    private final String SELECT_BY_ID = "select * from users where iduser = ?;";

    @Override
    public User authorization(String login, String password) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = executor.select(SELECT_BY_LOGIN_N_PASSWORD,login,password);
        User user = null;
        List<User> userList = convertToList(resultSet);
        executor.close();
        if (userList.size() > 0) {
            user = userList.get(0);
        }
        return user;
    }

    @Override
    public boolean registration(RegistrationInfo regInfo) throws DAOException {
        addUser(regInfo.getLogin(), regInfo.getPassword(), Role.CLIENT.getIdRole(), UserStatus.ACTIVE.getId());
        UserDetailDAO userDetailDAO = new SQLUserDetailDAO();
        int id = getUserId(regInfo.getLogin());
        return userDetailDAO.addUserDetail(id) &&
                    userDetailDAO.updateParameter(Parameter.EMAIL, id, regInfo.getUserDetail().getEmail());

    }

    public List<User> convertToList(ResultSet resultSet) {
        List<User> userList = new ArrayList<>();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    userList.add(new User(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4),
                            resultSet.getInt(5)));
                }
            } catch (SQLException e) {
                Logger.getLogger(SQLServiceDAO.class).info(e.getMessage());
            }
        }
        return userList;
    }



    public boolean check(String login) throws DAOException {

        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = executor.select(CHECK_BY_LOGIN, login);
        int result = 0;
        try {
            if(resultSet.next()) {
                result = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            Logger.getLogger(SQLUserDAO.class).info(e);
            throw new DAOException("failed in checking user by login", e);
        } finally {
            executor.close();
        }
        return result >= 1;
    }

    public boolean check(String login, String password) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = executor.select(CHECK_BY_LOGIN_N_PASSWORD, login, password);
        int result=0;
        try {
            if(resultSet.next()) {
                result = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new DAOException("failed in checking user by login and password", e);
        }
        return result >= 1;
    }

    @Override
    public boolean delete(int userId) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        int deleteLogin = executor.update(DELETE_LOGIN);
        int deletePassword = executor.update(DELETE_PASSWORD);
        int updateResult = executor.update(UPDATE_STATUS, UserStatus.DELETED.getId());
        executor.close();
        return deleteLogin == 1 && deletePassword == 1 && updateResult ==1;
    }

    public boolean addUser(String login, String password, int idrole, int idStatus) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        int result = executor.update(INSERT_USER, login, password, idrole, idStatus);
        executor.close();
        return result > 0;
    }

    public int getUserId(String login) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = executor.select(SELECT_ID_BY_LOGIN, login);
        int userId=0;
        try {
            if (resultSet.next()) {
                userId = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new DAOException("failed in getting userId", e);
        }
        return userId;
    }

    public List<User> getBy(Parameter parameter, Object value) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = null;
        switch (parameter) {
            case LOGIN:
                resultSet = executor.select(SELECT_BY_LOGIN, value);
                break;
            case ROLE:
                resultSet = executor.select(SELECT_BY_ROLE, value);
                break;
            case STATUS:
                resultSet = executor.select(SELECT_BY_STATUS, value);
                break;
            case ID:
                resultSet = executor.select(SELECT_BY_ID, value);
                break;
            default:
                resultSet = executor.select(SELECT_ALL);
                break;
        }
        List <User> userList = convertToList(resultSet);
        executor.close();
        return userList;
    }

    public boolean update(Parameter parameter, User user, Object value) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        int result;
        switch (parameter) {
            case PASSWORD:
                result = executor.update(UPDATE_PASSWORD, value, user.getId());
                break;
            case STATUS:
                result = executor.update(UPDATE_STATUS, value, user.getId());
                break;
            case ROLE:
                result = executor.update(UPDATE_ROLE, value, user.getId());
                break;
            default: result = 0;
        }
        executor.close();
        return result == 1;
    }
}
