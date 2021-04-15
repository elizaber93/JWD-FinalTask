package by.epam.training.javaWEB.finalTask.controller.command.impl;

import by.epam.training.javaWEB.finalTask.bean.Supplier;
import by.epam.training.javaWEB.finalTask.controller.command.Command;
import by.epam.training.javaWEB.finalTask.service.ServiceProvider;
import by.epam.training.javaWEB.finalTask.service.exception.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateSupplier implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Supplier supplier = new Supplier();
        supplier.setIdSupplier(Integer.parseInt(request.getParameter("id")));
        supplier.setName(request.getParameter("name"));
        supplier.setRequisites(request.getParameter("requisites"));
        Logger.getLogger(UpdateSupplier.class).info(supplier);
        try {
            ServiceProvider.getInstance().getSupplierService().updateSupplier(supplier);
            response.sendRedirect("Controller?command=see_suppliers");
        } catch (ServiceException e) {
            Logger.getLogger(UpdateSupplier.class).info(e);
            response.sendRedirect("Controller?command=goto&page=index&message=wrong");
        }

    }
}
