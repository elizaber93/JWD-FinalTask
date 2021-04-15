package by.epam.training.javaWEB.finalTask.dao.daoInterface;

import by.epam.training.javaWEB.finalTask.bean.Supplier;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.dao.impl.Parameter;

import java.util.List;

public interface SupplierDAO {
     boolean addSupplier(Supplier supplier) throws DAOException;
     boolean deleteSupplier(Supplier supplier) throws DAOException;
     List<Supplier> getBy(Parameter parameter, Object ... value) throws DAOException;
     boolean check(String name) throws DAOException;
     boolean check(int id) throws DAOException;
     List<Supplier> getSupplierList() throws DAOException;
     boolean update(Parameter parameter, int id, Object value) throws DAOException;
}
