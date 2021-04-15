package by.epam.training.javaWEB.finalTask.service.impl;

import by.epam.training.javaWEB.finalTask.bean.AuthorizationInfo;
import by.epam.training.javaWEB.finalTask.bean.RegistrationInfo;
import by.epam.training.javaWEB.finalTask.bean.User;
import by.epam.training.javaWEB.finalTask.bean.UserDetail;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.dao.daoInterface.UserDAO;
import by.epam.training.javaWEB.finalTask.dao.daoInterface.UserDetailDAO;
import by.epam.training.javaWEB.finalTask.dao.impl.Parameter;
import by.epam.training.javaWEB.finalTask.dao.impl.SQLUserDetailDAO;
import by.epam.training.javaWEB.finalTask.service.exception.InvalidLoginException;
import by.epam.training.javaWEB.finalTask.service.exception.InvalidPasswordException;
import by.epam.training.javaWEB.finalTask.dao.impl.SQLUserDAO;
import by.epam.training.javaWEB.finalTask.service.exception.OccupiedLoginException;
import by.epam.training.javaWEB.finalTask.service.exception.ServiceException;
import by.epam.training.javaWEB.finalTask.service.serviceInterface.UserService;
import by.epam.training.javaWEB.finalTask.service.serviceInterface.ValidationService;
import org.apache.log4j.Logger;

public class UserServiceImpl implements UserService {
    @Override
    public User authorization(AuthorizationInfo info) throws ServiceException, InvalidLoginException, InvalidPasswordException {
        UserDAO userDAO = new SQLUserDAO();
        try {
            if (!userDAO.check(info.getLogin())) {
                throw new InvalidLoginException("Login not found");
            }
            if (!userDAO.check(info.getLogin(), info.getPassword())) {
                throw new InvalidPasswordException("Illegal password");
            }
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
        User user = null;
        try {
            user = new SQLUserDAO().authorization(info.getLogin(), info.getPassword());
        } catch (DAOException e) {
            throw new ServiceException("Authorization failed", e);
        }
        return user;
    }

    @Override
    public boolean registration(RegistrationInfo regInfo) throws ServiceException, InvalidLoginException, InvalidPasswordException {
        boolean  regResult = false;
        UserDAO userDAO = new SQLUserDAO();
        ValidationService validationService = new ValidationServiceImpl();
        if (!validationService.isValidLogin(regInfo.getLogin())) {
            throw new InvalidLoginException("Invalid login");
        }
        if (!validationService.isValidPassword(regInfo.getPassword())) {
            throw new InvalidPasswordException("Invalid password");
        }
        try {
            if (userDAO.check(regInfo.getLogin())) {
                throw new OccupiedLoginException("Login already exists");
            }
        } catch(DAOException e) {
            throw new ServiceException(e.getMessage());
        }
        try {
            regResult = userDAO.registration(regInfo);
        } catch (DAOException e) {
            Logger.getLogger(UserServiceImpl.class).info(e);
            throw new ServiceException("Registration failed", e);
        }

        return regResult;
    }

    public boolean updateUserDetail(int userId, UserDetail userDetail) throws ServiceException {
        UserDetailDAO userDetailDAO = new SQLUserDetailDAO();
        userDetail.setUserId(userId);
        boolean result;
        try {
            result = userDetailDAO.updateAll(userDetail);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean deleteUser(User user) throws ServiceException {
        UserDAO userDAO = new SQLUserDAO();
        UserDetailDAO userDetailDAO = new SQLUserDetailDAO();
        boolean result;
        try {
            result = userDetailDAO.deleteUserDetail(user.getId());
            result = result && userDAO.delete(user.getId());
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
        return result;
    }

    @Override
    public UserDetail getUserDetail(int userId) throws ServiceException {
        UserDetailDAO userDetailDAO = new SQLUserDetailDAO();
        UserDetail userDetail = null;
        try {
            userDetail = userDetailDAO.getUserDetail(userId);
        } catch (DAOException e) {
            throw new ServiceException("Failed in getting userDetails",e);
        }
        return userDetail;
    }
}
