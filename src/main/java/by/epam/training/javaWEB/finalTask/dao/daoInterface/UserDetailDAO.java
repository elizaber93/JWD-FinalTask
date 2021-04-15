package by.epam.training.javaWEB.finalTask.dao.daoInterface;

import by.epam.training.javaWEB.finalTask.bean.User;
import by.epam.training.javaWEB.finalTask.bean.UserDetail;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.dao.impl.Parameter;

public interface UserDetailDAO {
    boolean addUserDetail(int userId) throws DAOException;
    boolean updateAll(UserDetail userDetail) throws DAOException;
    boolean updateParameter(Parameter parameter, int userId, Object value) throws DAOException;
    boolean deleteUserDetail(int userId) throws DAOException;
    UserDetail getUserDetail(int userId) throws DAOException;
}
