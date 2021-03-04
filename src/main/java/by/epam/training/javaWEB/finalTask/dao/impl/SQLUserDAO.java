package by.epam.training.javaWEB.finalTask.dao.impl;

import by.epam.training.javaWEB.finalTask.bean.RegistrationInfo;
import by.epam.training.javaWEB.finalTask.bean.User;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.dao.UserDAO;

public class SQLUserDAO implements UserDAO {
    static {
        MySQLDriverLoader.getInstance();
    }

    @Override
    public User authorization(String login, String password) throws DAOException {

        System.out.println("USER AUTHORIZATION");

        return new User();
    }

    @Override
    public boolean registration(RegistrationInfo regInfo) {
        // TODO Auto-generated method stub
        return false;
    }
}
