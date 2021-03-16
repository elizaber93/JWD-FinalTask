package by.epam.training.javaWEB.finalTask.service.impl;

import by.epam.training.javaWEB.finalTask.bean.RegistrationInfo;
import by.epam.training.javaWEB.finalTask.bean.User;
import by.epam.training.javaWEB.finalTask.connection.ConnectionPool;
import by.epam.training.javaWEB.finalTask.connection.ConnectionPoolException;
import by.epam.training.javaWEB.finalTask.service.ServiceException;
import by.epam.training.javaWEB.finalTask.service.UserService;

import java.sql.Connection;

public class UserServiceImpl implements UserService {
    @Override
    public User authorization(String login, String password) throws ServiceException {
        //подключение к бдб определение роли, возврат юзера
        return null;
    }

    @Override
    public boolean registration(RegistrationInfo regInfo) throws ServiceException {

        return false;
    }
}
