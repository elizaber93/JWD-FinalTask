package by.epam.training.javaWEB.finalTask.service.serviceInterface;

import by.epam.training.javaWEB.finalTask.bean.AuthorizationInfo;
import by.epam.training.javaWEB.finalTask.bean.RegistrationInfo;
import by.epam.training.javaWEB.finalTask.bean.User;
import by.epam.training.javaWEB.finalTask.service.exception.InvalidLoginException;
import by.epam.training.javaWEB.finalTask.service.exception.InvalidPasswordException;
import by.epam.training.javaWEB.finalTask.service.exception.ServiceException;

public interface UserService {
    User authorization(AuthorizationInfo info) throws ServiceException;
    boolean registration(RegistrationInfo regInfo) throws ServiceException, InvalidLoginException, InvalidPasswordException;

}
