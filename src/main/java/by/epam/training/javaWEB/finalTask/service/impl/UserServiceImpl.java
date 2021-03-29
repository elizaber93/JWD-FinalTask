package by.epam.training.javaWEB.finalTask.service.impl;

import by.epam.training.javaWEB.finalTask.bean.AuthorizationInfo;
import by.epam.training.javaWEB.finalTask.bean.RegistrationInfo;
import by.epam.training.javaWEB.finalTask.bean.User;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.service.exception.InvalidLoginException;
import by.epam.training.javaWEB.finalTask.service.exception.InvalidPasswordException;
import by.epam.training.javaWEB.finalTask.dao.impl.SQLUserDAO;
import by.epam.training.javaWEB.finalTask.service.exception.ServiceException;
import by.epam.training.javaWEB.finalTask.service.serviceInterface.UserService;
import by.epam.training.javaWEB.finalTask.service.serviceInterface.ValidationService;

public class UserServiceImpl implements UserService {
    @Override
    public User authorization(AuthorizationInfo info) throws ServiceException {
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
        ValidationService validationService = new ValidationServiceImpl();
        if (!validationService.isValidLogin(regInfo.getLogin())) {
            throw new InvalidLoginException("Invalid login");
        }
        if (!validationService.isValidPassword(regInfo.getPassword())) {
            throw new InvalidPasswordException("Invalid password");
        }
        try {
            regResult = new SQLUserDAO().registration(regInfo);
        } catch (DAOException e) {
            throw new ServiceException("Registration failed", e);
        }
        return regResult;
    }
}
