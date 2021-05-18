package by.epam.training.javaWEB.finalTask.controller.command.impl;

import by.epam.training.javaWEB.finalTask.bean.Product;
import by.epam.training.javaWEB.finalTask.bean.Supplier;
import by.epam.training.javaWEB.finalTask.controller.command.Command;
import by.epam.training.javaWEB.finalTask.controller.util.Page;
import by.epam.training.javaWEB.finalTask.service.ServiceProvider;
import by.epam.training.javaWEB.finalTask.service.exception.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SupplyAddition implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> productNames = new ArrayList<>();
        try {
            for (Product product : ServiceProvider.getInstance().getProductService().getProductList()) {
                productNames.add(product.getName());
            }
        } catch (ServiceException e) {
            //Logger.getLogger(SupplyAddition.class).info(e);
        }

        request.setAttribute("productList",productNames);
        List<String> supplierNames = new ArrayList<>();
        try {
            for (Supplier supplier : ServiceProvider.getInstance().getSupplierService().getSupplierList()) {
                supplierNames.add(supplier.getName());
            }
        } catch (ServiceException e) {
            Logger.getLogger(SupplyAddition.class).info(e);
        }
        request.setAttribute("supplierList",supplierNames);
        request.getRequestDispatcher(Page.ADD_SUPPlY.getPath()).forward(request,response);
    }
}
