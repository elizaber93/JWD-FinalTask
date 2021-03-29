package by.epam.training.javaWEB.finalTask.dao.daoInterface;

import by.epam.training.javaWEB.finalTask.bean.Supply;
import by.epam.training.javaWEB.finalTask.dao.DAOException;

public interface SupplyDAO {
    boolean addSupply(Supply supply) throws DAOException;
}
