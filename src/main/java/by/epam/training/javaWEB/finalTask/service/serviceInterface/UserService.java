package by.epam.training.javaWEB.finalTask.service.serviceInterface;

import by.epam.training.javaWEB.finalTask.bean.AuthorizationInfo;
import by.epam.training.javaWEB.finalTask.bean.RegistrationInfo;
import by.epam.training.javaWEB.finalTask.bean.User;
import by.epam.training.javaWEB.finalTask.bean.UserDetail;
import by.epam.training.javaWEB.finalTask.service.exception.InvalidLoginException;
import by.epam.training.javaWEB.finalTask.service.exception.InvalidPasswordException;
import by.epam.training.javaWEB.finalTask.service.exception.ServiceException;

import java.util.List;

public interface UserService {
    User authorization(AuthorizationInfo info) throws ServiceException, InvalidLoginException, InvalidPasswordException;
    boolean registration(RegistrationInfo regInfo) throws ServiceException, InvalidLoginException, InvalidPasswordException;
    boolean updateUserDetail(int userId, UserDetail userDetail) throws ServiceException;
    boolean deleteUser(User user) throws ServiceException;
    UserDetail getUserDetail(int userId) throws ServiceException;
    List<User> getUserList() throws ServiceException;
    boolean updateUser(int userId, User user) throws ServiceException;
}
