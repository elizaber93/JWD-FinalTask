package by.epam.training.javaWEB.finalTask.controller.command.impl;

import by.epam.training.javaWEB.finalTask.bean.Service;
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
import java.util.Map;

public class SeeServiceList implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceProvider provider = ServiceProvider.getInstance();
        ProductService productService = provider.getProductService();
        try {
            List<Service> serviceList= productService.getServiceList();
            Map<Integer,String> categories = productService.getCategories();
            Map<Integer,String> statuses = productService.getStatuses();
            request.setAttribute("statuses", statuses);
            request.setAttribute("categories", categories);
            request.setAttribute("serviceList",serviceList);
            request.getRequestDispatcher(Page.SERVICE_LIST.getPath()).forward(request,response);
        } catch (ServiceException e) {
            Logger.getLogger(SeeSupplierList.class).info(e);
            response.sendRedirect("Controller?command=goto&page=index&message=error");
        }
    }
}
