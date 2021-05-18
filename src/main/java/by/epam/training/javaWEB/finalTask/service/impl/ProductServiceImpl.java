package by.epam.training.javaWEB.finalTask.service.impl;

import by.epam.training.javaWEB.finalTask.bean.*;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.dao.DAOProvider;
import by.epam.training.javaWEB.finalTask.dao.daoInterface.ProductDAO;
import by.epam.training.javaWEB.finalTask.dao.daoInterface.ProductDetailDAO;
import by.epam.training.javaWEB.finalTask.dao.daoInterface.ServiceDAO;
import by.epam.training.javaWEB.finalTask.dao.impl.Parameter;
import by.epam.training.javaWEB.finalTask.service.exception.ServiceException;
import by.epam.training.javaWEB.finalTask.service.serviceInterface.ProductService;

import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    @Override
    public List<ProductProperty> getPropertyList() throws ServiceException {
        List<ProductProperty> propertyList = null;
        try {
            propertyList = DAOProvider.getInstance().getProductDetailDAO().getPropertyList();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return propertyList;
    }



    @Override
    public boolean addProduct(Product product) throws ServiceException {
        ProductDAO productDAO = DAOProvider.getInstance().getProductDAO();
        ProductDetailDAO productDetailDAO = DAOProvider.getInstance().getProductDetailDAO();
        boolean result = false;
        try {
            result = productDAO.addProduct(product);
            for (ProductDetail detail : product.getDetails()) {
                result &= productDetailDAO.addDetail(product, detail.getPropertyName(), detail.getValue());
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public boolean addService(Service service) throws ServiceException {
        ServiceDAO serviceDAO = DAOProvider.getInstance().getServiceDAO();
        boolean result = false;
        try {
            result = serviceDAO.addService(service);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public void updateProduct(int id, Product product) throws ServiceException {
        product.setIdProduct(id);
        ProductDAO productDAO = DAOProvider.getInstance().getProductDAO();
        ProductDetailDAO productDetailDAO = DAOProvider.getInstance().getProductDetailDAO();
        try {
            if (product.getName() != null) {
                productDAO.update(Parameter.NAME, id, product.getName());
            }
            if (product.getDescription() != null) {
                productDAO.update(Parameter.DESCRIPTION, id, product.getDescription());
            }
            if (product.getImageLink() != null) {
                productDAO.update(Parameter.IMAGE, id, product.getImageLink());
            }
            for (ProductDetail detail : product.getDetails()) {
                productDetailDAO.updateDetail(product, detail.getPropertyName(), detail.getValue());
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteProduct(int id) throws ServiceException {
        ProductDAO productDAO = DAOProvider.getInstance().getProductDAO();
        try {
            productDAO.update(Parameter.STATUS,id, ServiceStatus.LOCKED);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteService(int id) throws ServiceException {

    }

    @Override
    public void updateService(int id, Service service) throws ServiceException {
        ServiceDAO serviceDAO = DAOProvider.getInstance().getServiceDAO();
        try {
            if (service.getCategory() != null) {
                serviceDAO.update(Parameter.CATEGORY,id,service.getCategory());
            }
            if (service.getName() != null) {
                serviceDAO.update(Parameter.NAME,id,service.getName());
            }
            if (service.getDescription() != null) {
                serviceDAO.update(Parameter.DESCRIPTION,id,service.getDescription());
            }
            if (service.getPrice() > 0) {
                serviceDAO.update(Parameter.PRICE,id,service.getPrice());
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Product> getProductList() throws ServiceException {
        ProductDAO productDAO = DAOProvider.getInstance().getProductDAO();
        List<Product> productList = null;
        try{
            productList = productDAO.getProductList();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return productList;
    }

    @Override
    public List<Service> getServiceList() throws ServiceException {
        ServiceDAO serviceDAO = DAOProvider.getInstance().getServiceDAO();
        List<Service> serviceList = null;
        try{
            serviceList = serviceDAO.getServiceList();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return serviceList;
    }

    @Override
    public Map<Integer, String> getCategories() throws ServiceException {
        Map<Integer,String> categories = null;
        try {
            categories = DAOProvider.getInstance().getEnumDAO().getCategories();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return categories;
    }

    @Override
    public Map<Integer, String> getStatuses() throws ServiceException {
        Map<Integer,String> statuses = null;
        try {
            statuses = DAOProvider.getInstance().getEnumDAO().getStatuses();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return statuses;
    }
}
