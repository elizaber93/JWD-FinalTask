package by.epam.training.javaWEB.finalTask.dao.daoInterface;

import by.epam.training.javaWEB.finalTask.bean.ProductDetail;
import by.epam.training.javaWEB.finalTask.dao.DAOException;

import java.util.List;

public interface ProductDetailDAO {

    List<ProductDetail> getProductDetailList(int id) throws DAOException;
}
