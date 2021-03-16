package by.epam.training.javaWEB.finalTask.service;

import by.epam.training.javaWEB.finalTask.bean.RegistrationInfo;

public interface ValidationService {
    public boolean isValid(RegistrationInfo regInfo) throws ServiceException;
}
