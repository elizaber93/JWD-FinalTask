package by.epam.training.javaWEB.finalTask.controller.command.impl;

import by.epam.training.javaWEB.finalTask.bean.Product;
import by.epam.training.javaWEB.finalTask.bean.builder.ProductBuilder;
import by.epam.training.javaWEB.finalTask.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateProduct implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = new ProductBuilder()
                            .setProductId(Integer.parseInt(request.getParameter("id")))
                            .setName(request.getParameter("name"))
                            .setDescription(request.getParameter("description"))
                            .build();
    }
}
