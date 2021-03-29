package by.epam.training.javaWEB.finalTask.service.impl;

import by.epam.training.javaWEB.finalTask.bean.RegistrationInfo;
import by.epam.training.javaWEB.finalTask.service.exception.ServiceException;
import by.epam.training.javaWEB.finalTask.service.serviceInterface.ValidationService;

public class ValidationServiceImpl implements ValidationService {
    private final String LOGINREGEX = "[a-zA-Z0-9_]+";
    private final String PASSWORDREGEX = "[a-zA-Z0-9_]{7,}";
    private final String EMAILREGEX = "[a-zA-Z0-9\\.\\-_]+@[a-z]+\\.[a-z]+";
    public ValidationServiceImpl() {

    }

    public boolean isValidLogin(String login) {
        return login.matches(LOGINREGEX);
    }

    public boolean isValidPassword(String password) {
        return password.matches(PASSWORDREGEX);
    }

    public  boolean isValidEmail(String email) {
        return email.matches(EMAILREGEX);
    }

    public boolean isValid(RegistrationInfo regInfo) throws ServiceException {
        if (regInfo.getLogin().matches(LOGINREGEX) && regInfo.getPassword().matches(PASSWORDREGEX)) {
            return true;
        }
        if (!regInfo.getLogin().matches(LOGINREGEX)) {
            throw new ServiceException("Логин должен состоять из латинских букв, цифр и знака подчеркивания");
        }
        if (!regInfo.getPassword().matches(PASSWORDREGEX)) {
            throw new ServiceException("Password isn't valid");
        }
        return false;
    }
}
