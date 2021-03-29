package by.epam.training.javaWEB.finalTask.dao.daoInterface;

import by.epam.training.javaWEB.finalTask.bean.UserDetail;
import by.epam.training.javaWEB.finalTask.dao.DAOException;

public interface UserDetailDAO {
    void addUserDetail(UserDetail userDetail) throws DAOException;
    void updateUserDetail(UserDetail userDetail) throws DAOException;
}
