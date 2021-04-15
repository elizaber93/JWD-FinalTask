package by.epam.training.javaWEB.finalTask.dao.daoInterface;

import by.epam.training.javaWEB.finalTask.bean.Supply;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.dao.impl.Parameter;

import java.util.List;

public interface SupplyDAO {
    boolean addSupply(Supply supply) throws DAOException;
    boolean deleteSupply(Supply supply) throws DAOException;
    List<Supply> getBy(Parameter parameter, Object value) throws DAOException;
}
