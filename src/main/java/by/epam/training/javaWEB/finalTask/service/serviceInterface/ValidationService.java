package by.epam.training.javaWEB.finalTask.service.serviceInterface;

import by.epam.training.javaWEB.finalTask.bean.RegistrationInfo;
import by.epam.training.javaWEB.finalTask.service.exception.ServiceException;

public interface ValidationService {
    boolean isValid(RegistrationInfo regInfo) throws ServiceException;
    boolean isValidLogin(String login);
    boolean isValidPassword(String password);

}
