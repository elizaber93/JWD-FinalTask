package by.epam.training.javaWEB.finalTask.controller.command.impl;

import by.epam.training.javaWEB.finalTask.bean.ProductProperty;
import by.epam.training.javaWEB.finalTask.controller.command.Command;
import by.epam.training.javaWEB.finalTask.controller.util.Page;
import by.epam.training.javaWEB.finalTask.service.ServiceProvider;
import by.epam.training.javaWEB.finalTask.service.exception.ServiceException;
import by.epam.training.javaWEB.finalTask.service.serviceInterface.ProductService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductAddition implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = ServiceProvider.getInstance().getProductService();
        List<ProductProperty> propertyList = null;
        try {
            propertyList = productService.getPropertyList();
        } catch (ServiceException e) {
            Logger.getLogger(ProductAddition.class).info(e);
            response.sendRedirect("Controller?command=goto&page=index&message=error");
        }
        request.setAttribute("propertyList", propertyList);
        request.getRequestDispatcher(Page.ADD_PRODUCT.getPath()).forward(request,response);
    }
}
