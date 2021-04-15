package by.epam.training.javaWEB.finalTask.dao.daoInterface;

import by.epam.training.javaWEB.finalTask.bean.RegistrationInfo;
import by.epam.training.javaWEB.finalTask.bean.User;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.dao.impl.Parameter;

import java.util.List;

public interface UserDAO {
    User authorization (String login, String password) throws DAOException;
    boolean	registration(RegistrationInfo regInfo) throws DAOException;
    boolean check(String login) throws DAOException;
    boolean check(String login, String password) throws DAOException;
    boolean delete(int userId) throws DAOException;
    List<User> getBy(Parameter parameter, Object value) throws DAOException;

}
