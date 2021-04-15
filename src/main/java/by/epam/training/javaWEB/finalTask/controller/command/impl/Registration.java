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
import org.apache.log4j.Logger;

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

        info.setLogin(request.getParameter("login_reg"));
        info.setPassword(request.getParameter("password_reg"));
        info.getUserDetail().setEmail(request.getParameter("email"));

        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();

        User user = null;
        RequestDispatcher requestDispatcher = null;
        boolean isRegistered = false;
        try {
            isRegistered = userService.registration(info);
            if (isRegistered) {
                user = userService.authorization(new AuthorizationInfo(info.getLogin(), info.getPassword()));
            } else {
                response.sendRedirect("Controller?command=goto&page=index&message=wrong2");
                return;
            }

            if (user == null) {
                response.sendRedirect("Controller?command=goto&page=index&message=wrong2");
                return;
            }

            response.sendRedirect("Controller?command=goto&page=index&message=succesfulRegistration");


            HttpSession session = request.getSession(true);
            session.setAttribute("auth", true);


        } catch (InvalidLoginException e) {
            response.sendRedirect("Controller?command=goto&page=index&message=wrong in login");
        } catch (InvalidPasswordException e) {
            response.sendRedirect("Controller?command=goto&page=index&message=wrong in password");
        } catch (ServiceException e) {
            Logger.getLogger(Registration.class).info(e);
            response.sendRedirect("Controller?command=goto&page=index&message=wrong in catch");
        }
    }
}
