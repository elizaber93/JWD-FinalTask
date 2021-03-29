package by.epam.training.javaWEB.finalTask;

import by.epam.training.javaWEB.finalTask.bean.RegistrationInfo;
import by.epam.training.javaWEB.finalTask.bean.Supplier;
import by.epam.training.javaWEB.finalTask.bean.UserDetail;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.dao.daoInterface.ProductDAO;
import by.epam.training.javaWEB.finalTask.dao.daoInterface.SupplierDAO;
import by.epam.training.javaWEB.finalTask.dao.impl.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        RegistrationInfo regInfo = new RegistrationInfo();
        regInfo.setLogin("eliz45");
        regInfo.setPassword("1234567");
        SQLUserDAO sqlUserDAO = new SQLUserDAO();
        try {
            sqlUserDAO.registration(regInfo);
        } catch (DAOException e) {
            System.out.println("регистрация не удалась");
            System.out.println(e.getMessage());
        }

        UserDetail userDetail = new UserDetail();
        userDetail.setUserId(2);
        userDetail.setFirstName("Lea");
        SQLUserDetailDAO sqlUserDetailDAO = new SQLUserDetailDAO();
        try {
            sqlUserDetailDAO.addUserDetail(userDetail);
        } catch (DAOException e) {
            System.out.println("не удалось добавить");
        }
        ProductDAO productDAO = new SQLProductDAO();

        try {
            System.out.println(productDAO.getProduct(1).getName());
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }

        SupplierDAO supplierDAO = new SQLSupplierDAO();
        try {
            List<Supplier> supplier = supplierDAO.getBy(Parameter.ID, 1);
            System.out.println(supplier);
            System.out.println(supplierDAO.update(Parameter.NAME, supplier.get(0), "supplier1"));
            supplier = supplierDAO.getBy(Parameter.ID, 1);
            System.out.println(supplier);

        } catch (DAOException e) {
            System.out.println(e.getMessage());
            System.out.println("Что-то пошло не так");
        }

    }
}
