package by.epam.training.javaWEB.finalTask.controller.command.impl;

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
import java.util.Map;

public class ServiceAddition implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = ServiceProvider.getInstance().getProductService();
        Map<Integer,String> categories = null;
        try {
            categories = productService.getCategories();
        } catch (ServiceException e) {
            Logger.getLogger(ProductAddition.class).info(e);
            response.sendRedirect("Controller?command=goto&page=index&message=error");
        }
        request.setAttribute("categories", categories);
        request.getRequestDispatcher(Page.ADD_SERVICE.getPath()).forward(request,response);
    }
}
