package by.epam.training.javaWEB.finalTask.service;

import by.epam.training.javaWEB.finalTask.bean.RegistrationInfo;
import by.epam.training.javaWEB.finalTask.bean.User;

public interface UserService {
    User authorization(String login, String password) throws ServiceException;
    boolean registration(RegistrationInfo regInfo) throws ServiceException;

}
