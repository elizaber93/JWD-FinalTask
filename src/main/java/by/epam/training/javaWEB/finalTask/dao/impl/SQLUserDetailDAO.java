package by.epam.training.javaWEB.finalTask.dao.impl;

import by.epam.training.javaWEB.finalTask.bean.Article;
import by.epam.training.javaWEB.finalTask.bean.User;
import by.epam.training.javaWEB.finalTask.bean.UserDetail;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.dao.daoInterface.UserDetailDAO;
import by.epam.training.javaWEB.finalTask.dao.executor.QueryExecutor;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLUserDetailDAO implements UserDetailDAO {

    private final String INSERT_USER = "insert into user_details (iduser) values (?);";
    private final String UPDATE_FIRST_NAME = "update user_details set first_name = ? where iduser = ?;";
    private final String UPDATE_LAST_NAME = "update user_details set last_name = ? where iduser = ?;";
    private final String UPDATE_PHONE = "update user_details set phone = ? where iduser = ?;";
    private final String UPDATE_ADDRESS = "update user_details set address = ? where iduser = ?;";
    private final String UPDATE_EMAIL = "update user_details set email = ? where iduser = ?;";
    private final String UPDATE_IMAGE_LINK = "update user_details set image = ? where iduser = ?;";
    private final String COUNT_EMAIL = "select count(*) from user_details where email = ?;";
    private final String DELETE_ENTRY = "delete from user_details where iduser = ?;";
    private final String SELECT_DETAIL = "select * from user_details where iduser = ?;";

    @Override
    public boolean addUserDetail(int userId) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        int insertResult = executor.update(INSERT_USER, userId);
        executor.close();
        return insertResult == 1;
    }

    public boolean updateAll(UserDetail userDetail) throws DAOException {
        boolean result = true;
        if (userDetail.getFirstName() != null) {
            result = updateParameter(Parameter.FIRST_NAME, userDetail.getUserId(),userDetail.getFirstName());
        }
        if (userDetail.getLastName() != null) {
            result = result && updateParameter(Parameter.LAST_NAME, userDetail.getUserId(),userDetail.getLastName());
        }
        if (userDetail.getPhone() != null) {
            result = result && updateParameter(Parameter.PHONE, userDetail.getUserId(),userDetail.getPhone());
        }
        if (userDetail.getEmail() != null) {
            result = result && updateParameter(Parameter.EMAIL, userDetail.getUserId(),userDetail.getEmail());
        }
        if (userDetail.getAddress() != null) {
            result = result && updateParameter(Parameter.ADDRESS, userDetail.getUserId(),userDetail.getAddress());
        }
        if (userDetail.getImageLink() != null) {
            result = result && updateParameter(Parameter.IMAGE, userDetail.getUserId(),userDetail.getImageLink());
        }
        return result;
    }

    public boolean updateParameter(Parameter parameter, int userId, Object value) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        int result;
        if (!(value instanceof String)) {
            throw new DAOException("Illegal type");
        }
        switch (parameter) {
            case FIRST_NAME:
                result = executor.update(UPDATE_FIRST_NAME, value, userId);
                break;
            case LAST_NAME:
                result = executor.update(UPDATE_LAST_NAME, value, userId);
                break;
            case PHONE:
                result = executor.update(UPDATE_PHONE, value, userId);
                break;
            case ADDRESS:
                result = executor.update(UPDATE_ADDRESS, value, userId);
                break;
            case EMAIL:
                result = executor.update(UPDATE_EMAIL, value, userId);
                break;
            case IMAGE:
                result = executor.update(UPDATE_IMAGE_LINK, value, userId);
                break;
            default: result = 0;
        }
        executor.close();
        return result == 1;
    }

    @Override
    public boolean deleteUserDetail(int userId) throws DAOException {
        QueryExecutor executor = QueryExecutor.getInstance();
        int insertResult = executor.update(DELETE_ENTRY, userId);
        executor.close();
        return insertResult == 1;
    }

    @Override
    public UserDetail getUserDetail(int userId) throws DAOException {
        UserDetail userDetail = new UserDetail();
        QueryExecutor executor = QueryExecutor.getInstance();
        ResultSet resultSet = executor.select(SELECT_DETAIL,userId);
        userDetail = convertToList(resultSet).get(0);
        executor.close();
        return userDetail;
    }

    public List<UserDetail> convertToList(ResultSet resultSet) {
        List<UserDetail> userDetails = new ArrayList<>();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    userDetails.add(new UserDetail(resultSet.getInt(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8)));
                }
            } catch (SQLException e) {
                Logger.getLogger(SQLServiceDAO.class).info(e.getMessage());
            }
        }
        return userDetails;
    }
}
