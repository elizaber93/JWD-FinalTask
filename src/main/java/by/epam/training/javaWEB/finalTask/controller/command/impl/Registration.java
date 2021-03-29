package by.epam.training.javaWEB.finalTask.controller.command.impl;

import by.epam.training.javaWEB.finalTask.bean.AuthorizationInfo;
import by.epam.training.javaWEB.finalTask.bean.RegistrationInfo;
import by.epam.training.javaWEB.finalTask.bean.User;
import by.epam.training.javaWEB.finalTask.controller.command.Command;
import by.epam.training.javaWEB.finalTask.service.ServiceProvider;
import by.epam.training.javaWEB.finalTask.service.exception.InvalidLoginException;
import by.epam.training.javaWEB.finalTask.service.exception.InvalidPasswordException;
import by.epam.training.javaWEB.finalTask.service.exception.ServiceException;
import by.epam.training.javaWEB.finalTask.service.serviceInterface.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Registration implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RegistrationInfo info = new RegistrationInfo();

        info.setLogin(request.getParameter("login"));
        info.setPassword(request.getParameter("password"));

        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();

        User user = null;
        RequestDispatcher requestDispatcher = null;
        boolean isRegistered = false;
        try {
            if (userService.registration(info)) {
                 user = userService.authorization(new AuthorizationInfo(info.getLogin(), info.getPassword()));
            } else {
                response.sendRedirect("Controller?command=gotoindexpage&message=wrong2");
                return;
            }

            if (user == null) {
                response.sendRedirect("Controller?command=gotoindexpage&message=wrong2");
                return;
            }

            HttpSession session = request.getSession(true);
            session.setAttribute("auth", true);


            //open user profiles to add details
            // response.sendRedirect("Controller?command=gotouserdetailpage");

            response.sendRedirect("Controller?command=gotomainpage");

        } catch (ServiceException e) {
            response.sendRedirect("Controller?command=gotoindexpage&message=wrong in catch");
        } catch (InvalidLoginException e) {
            response.sendRedirect("Controller?command=gotoindexpage&message=wrong in login");
        } catch (InvalidPasswordException e) {
            response.sendRedirect("Controller?command=gotoindexpage&message=wrong in password");
        }
    }
}
