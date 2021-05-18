package by.epam.training.javaWEB.finalTask.controller.command.impl;

import by.epam.training.javaWEB.finalTask.bean.Product;
import by.epam.training.javaWEB.finalTask.bean.Supplier;
import by.epam.training.javaWEB.finalTask.controller.command.Command;
import by.epam.training.javaWEB.finalTask.controller.util.Page;
import by.epam.training.javaWEB.finalTask.service.ServiceProvider;
import by.epam.training.javaWEB.finalTask.service.exception.ServiceException;
import by.epam.training.javaWEB.finalTask.service.serviceInterface.ProductService;
import by.epam.training.javaWEB.finalTask.service.serviceInterface.SupplierService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SeeProductList implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceProvider provider = ServiceProvider.getInstance();
        ProductService productService = provider.getProductService();
        try {
            List<Product> productList= productService.getProductList();
            request.setAttribute("productList",productList);
            request.getRequestDispatcher(Page.PRODUCT_LIST.getPath()).forward(request,response);
        } catch (ServiceException e) {
            Logger.getLogger(SeeSupplierList.class).info(e);
            response.sendRedirect("Controller?command=goto&page=index&message=error");
        }
    }
}
