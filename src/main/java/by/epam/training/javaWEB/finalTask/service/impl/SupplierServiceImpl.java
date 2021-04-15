package by.epam.training.javaWEB.finalTask.service.impl;

import by.epam.training.javaWEB.finalTask.bean.Supplier;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.dao.DAOProvider;
import by.epam.training.javaWEB.finalTask.dao.daoInterface.SupplierDAO;
import by.epam.training.javaWEB.finalTask.dao.impl.Parameter;
import by.epam.training.javaWEB.finalTask.dao.impl.SQLSupplierDAO;
import by.epam.training.javaWEB.finalTask.service.exception.ServiceException;
import by.epam.training.javaWEB.finalTask.service.serviceInterface.SupplierService;
import org.apache.log4j.Logger;

import java.util.List;


public class SupplierServiceImpl implements SupplierService {
    @Override
    public boolean addSupplier(Supplier supplier) {
        SupplierDAO supplierDAO = DAOProvider.getInstance().getSupplierDAO();
        //validation
        try {
            if (supplierDAO.addSupplier(supplier)) return true;
        } catch (DAOException e) {
            Logger.getLogger(SupplierServiceImpl.class).info(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean isFound(Supplier supplier) throws ServiceException {
        SupplierDAO supplierDAO = DAOProvider.getInstance().getSupplierDAO();
        boolean result = false;
        if (supplier.getName()!=null) {
            try {
                result = supplierDAO.check(supplier.getName());
            } catch (DAOException e) {
                Logger.getLogger(SupplierServiceImpl.class);
                throw new ServiceException("Failed supplier finding", e);
            }
        }
        return result;
    }
    public List<Supplier> getSupplierList() throws ServiceException {
        SupplierDAO supplierDAO = DAOProvider.getInstance().getSupplierDAO();
        List<Supplier> result = null;
        try {
            result = supplierDAO.getSupplierList();
        } catch (DAOException e) {
            throw new ServiceException("Failed in getting supplier list", e);
        }
        return result;
    }

    @Override
    public boolean updateSupplier(Supplier supplier) throws ServiceException {
        SupplierDAO supplierDAO = DAOProvider.getInstance().getSupplierDAO();
        boolean result;
        try {
            result = supplierDAO.update(Parameter.NAME, supplier.getIdSupplier(), supplier.getName());
            result &= supplierDAO.update(Parameter.REQUISITES, supplier.getIdSupplier(), supplier.getRequisites());
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
        }
}
