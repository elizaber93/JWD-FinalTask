package by.epam.training.javaWEB.finalTask.controller.command.impl;

import by.epam.training.javaWEB.finalTask.bean.AuthorizationInfo;
import by.epam.training.javaWEB.finalTask.bean.Supplier;
import by.epam.training.javaWEB.finalTask.bean.User;
import by.epam.training.javaWEB.finalTask.controller.command.Command;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.service.ServiceProvider;
import by.epam.training.javaWEB.finalTask.service.exception.ServiceException;
import by.epam.training.javaWEB.finalTask.service.serviceInterface.SupplierService;
import by.epam.training.javaWEB.finalTask.service.serviceInterface.UserService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddSupplier implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceProvider provider = ServiceProvider.getInstance();
        SupplierService supplierService = provider.getSupplierService();

        Supplier supplier = new Supplier();
        supplier.setName(request.getParameter("name"));
        supplier.setRequisites(request.getParameter("requisite"));
        RequestDispatcher requestDispatcher = null;
        boolean isAdded = false;
        isAdded = supplierService.addSupplier(supplier);

        response.sendRedirect("Controller?command=goto&page=index&message=succesfulRegistration");

    }
}
