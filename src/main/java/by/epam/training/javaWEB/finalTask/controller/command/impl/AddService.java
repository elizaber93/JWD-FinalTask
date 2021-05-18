package by.epam.training.javaWEB.finalTask.controller.command.impl;

import by.epam.training.javaWEB.finalTask.bean.Service;
import by.epam.training.javaWEB.finalTask.bean.builder.ServiceBuilder;
import by.epam.training.javaWEB.finalTask.controller.command.Command;
import by.epam.training.javaWEB.finalTask.service.ServiceProvider;
import by.epam.training.javaWEB.finalTask.service.exception.ServiceException;
import by.epam.training.javaWEB.finalTask.service.serviceInterface.ProductService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddService implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service service = new ServiceBuilder()
                            .setName(request.getParameter("name"))
                            .setDescription(request.getParameter("description"))
                            .setPrice(Double.parseDouble(request.getParameter("price")))
                            .setCategory(request.getParameter("category"))
                            .build();
        Logger.getLogger(AddService.class).info(service);
        ProductService productService = ServiceProvider.getInstance().getProductService();
        try {
            productService.addService(service);
            response.sendRedirect("Controller?command=service_addition&message=ok");
        } catch (ServiceException e) {
            Logger.getLogger(AddService.class).info(e);
            response.sendRedirect("Controller?command=service_addition&message=error");
        }

    }
}
