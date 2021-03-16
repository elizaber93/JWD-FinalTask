package by.epam.training.javaWEB.finalTask.service.impl;

import by.epam.training.javaWEB.finalTask.bean.RegistrationInfo;
import by.epam.training.javaWEB.finalTask.service.ServiceException;
import by.epam.training.javaWEB.finalTask.service.ValidationService;

public class ValidationServiceImpl implements ValidationService {
    private final String LOGINREGEX = "[a-zA-Z0-9_]+";
    private final String PASSWORDREGEX = "[a-zA-Z0-9_]{7,}";
    public ValidationServiceImpl() {

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
