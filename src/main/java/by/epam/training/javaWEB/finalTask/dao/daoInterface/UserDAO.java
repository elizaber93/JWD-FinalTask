package by.epam.training.javaWEB.finalTask.dao.daoInterface;

import by.epam.training.javaWEB.finalTask.bean.RegistrationInfo;
import by.epam.training.javaWEB.finalTask.bean.User;
import by.epam.training.javaWEB.finalTask.dao.DAOException;

public interface UserDAO {
    User authorization (String login, String password) throws DAOException;
    boolean	registration(RegistrationInfo regInfo) throws DAOException;

}
