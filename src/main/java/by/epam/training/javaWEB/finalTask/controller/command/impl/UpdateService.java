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

public class UpdateService implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service service = new ServiceBuilder()
                .setId(Integer.parseInt(request.getParameter("id")))
                .setCategory(request.getParameter("category"))
                .setName(request.getParameter("name"))
                .setDescription(request.getParameter("description"))
                .setPrice(Double.parseDouble(request.getParameter("price")))
                .build();
        ProductService productService = ServiceProvider.getInstance().getProductService();
        try {
            productService.updateService(service.getIdService(),service);
            response.sendRedirect("Controller?command=see_services&message=ok");
        } catch (ServiceException e) {
            Logger.getLogger(UpdateService.class).info(e);
            response.sendRedirect("Controller?command=see_services&message=error");
        }
    }
}
