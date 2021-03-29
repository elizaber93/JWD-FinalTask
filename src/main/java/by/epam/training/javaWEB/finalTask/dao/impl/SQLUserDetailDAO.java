package by.epam.training.javaWEB.finalTask.dao.impl;

import by.epam.training.javaWEB.finalTask.bean.UserDetail;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.dao.daoInterface.UserDetailDAO;
import by.epam.training.javaWEB.finalTask.dao.executor.QueryExecutor;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUserDetailDAO implements UserDetailDAO {

    private final String INSERT_USER_ID = "insert into user_details (iduser) values (?);";
    private final String ADD_FIRST_NAME = "update user_details set first_name = ? where iduser = ?;";
    private final String ADD_LAST_NAME = "update user_details set last_name = ? where iduser = ?;";
    private final String ADD_PHONE = "update user_details set phone = ? where iduser = ?;";
    private final String ADD_ADDRESS = "update user_details set address = ? where iduser = ?;";
    private final String ADD_EMAIL = "update user_details set first_name = ? where iduser = ?;";
    private final String ADD_IMAGE_LINK = "update user_details set image = ? where iduser = ?;";
    private final String COUNT_EMAIL = "select count(*) from user_details where email = ?;";


    @Override
    public void addUserDetail(UserDetail userDetail) throws DAOException {
        long userId = userDetail.getUserId();
        if (insertUser((int)userId)) {
            updateUserDetail(userDetail);
        }
    }

    @Override
    public void updateUserDetail(UserDetail userDetail) throws DAOException {
        if (userDetail.getFirstName() != null) {
            addDetail(ADD_FIRST_NAME, userDetail.getFirstName(), (int)userDetail.getUserId());
        }
        if (userDetail.getLastName() != null) {
            addDetail(ADD_LAST_NAME, userDetail.getLastName(), (int)userDetail.getUserId());
        }
        if (userDetail.getAddress() != null) {
            addDetail(ADD_ADDRESS, userDetail.getAddress(),(int)userDetail.getUserId());
        }
        if (userDetail.getPhone() != null) {
            addDetail(ADD_PHONE, userDetail.getPhone(), (int) userDetail.getUserId());
        }
        if (userDetail.getEmail() != null) {
            addDetail(ADD_EMAIL, userDetail.getEmail(),(int) userDetail.getUserId());
        }
        if (userDetail.getImageLink() != null) {
            addDetail(ADD_IMAGE_LINK, userDetail.getImageLink(), (int) userDetail.getUserId());
        }
    }

    public void addDetail(String query, String value, int id) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        PreparedStatement statement = executor.getPreparedStatement(query);
        try {
            statement.setString(1,value);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(SQLUserDetailDAO.class).info(e.getMessage());
            throw new DAOException("Failed execution statement", e);
        } finally {
            executor.close();
        }
    }

    public boolean insertUser(int userId) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        PreparedStatement statement = executor.getPreparedStatement(INSERT_USER_ID);
        int result;
        try {
            statement.setInt(1,userId);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(SQLUserDetailDAO.class).info(e.getMessage());
            throw new DAOException("Failed execution statement", e);
        } finally {
            executor.close();
        }
        return result >= 1;
    }

    public boolean findEmail(String email) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        PreparedStatement statement = executor.getPreparedStatement(COUNT_EMAIL);
            ResultSet foundEntry = null;
            int result;
            try {
                statement.setString(1, email);
                foundEntry = statement.executeQuery();
                foundEntry.next();
                result = foundEntry.getInt(1);
            } catch (SQLException e) {
                Logger.getLogger(SQLUserDetailDAO.class);
                throw new DAOException("Failed execution statement", e);
            } finally {
                executor.close();
            }
            return result >= 1;
        }


}
