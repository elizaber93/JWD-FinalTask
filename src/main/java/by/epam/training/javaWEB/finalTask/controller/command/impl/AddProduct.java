package by.epam.training.javaWEB.finalTask.controller.command.impl;

import by.epam.training.javaWEB.finalTask.bean.Product;
import by.epam.training.javaWEB.finalTask.bean.ProductDetail;
import by.epam.training.javaWEB.finalTask.controller.command.Command;
import by.epam.training.javaWEB.finalTask.service.ServiceProvider;
import by.epam.training.javaWEB.finalTask.service.exception.ServiceException;
import by.epam.training.javaWEB.finalTask.service.serviceInterface.ProductService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddProduct implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int count = Integer.parseInt(request.getParameter("count"));
        Product product = new Product();
        product.setName(request.getParameter("name"));
        product.setDescription(request.getParameter("description"));

        ProductService productService = ServiceProvider.getInstance().getProductService();

        List<ProductDetail> detailList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ProductDetail detail = new ProductDetail();
            String propertyName = request.getParameter("property"+i);
            String propertyValue = request.getParameter("value"+i);

            detail.setPropertyName(propertyName);
            detail.setValue(propertyValue);
            detailList.add(detail);
        }
        product.setDetails(detailList);
        try {
            productService.addProduct(product);
            response.sendRedirect("Controller?command=product_addition");
        } catch (ServiceException e) {
            Logger.getLogger(AddProduct.class).info(e);
            response.sendRedirect("Controller?command=goto&page=index&message=error");
        }

    }
}
