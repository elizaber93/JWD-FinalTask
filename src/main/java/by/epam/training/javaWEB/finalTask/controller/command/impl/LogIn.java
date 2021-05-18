package by.epam.training.javaWEB.finalTask.controller.command.impl;

import by.epam.training.javaWEB.finalTask.bean.AuthorizationInfo;
import by.epam.training.javaWEB.finalTask.bean.Role;
import by.epam.training.javaWEB.finalTask.bean.User;
import by.epam.training.javaWEB.finalTask.controller.command.Command;
import by.epam.training.javaWEB.finalTask.service.exception.ServiceException;
import by.epam.training.javaWEB.finalTask.service.ServiceProvider;
import by.epam.training.javaWEB.finalTask.service.serviceInterface.UserService;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogIn implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AuthorizationInfo info = new AuthorizationInfo();

        info.setLogin(request.getParameter("login_log"));
        info.setPassword(request.getParameter("password_log"));

        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();

        User user = null;
        RequestDispatcher requestDispatcher = null;
        try {
            user = userService.authorization(info);

            if (user == null) {
                response.sendRedirect("Controller?command=goto&page=index&message=wrong2");
                return;
            }

            HttpSession session = request.getSession(true);
            session.setAttribute("auth", true);
            session.setAttribute("userId",user.getId());
            session.setAttribute("role", user.getRole());




            response.sendRedirect("Controller?command=goto&page=index");

        } catch (ServiceException e) {
            Logger.getLogger(LogIn.class).info(e);
            response.sendRedirect("Controller?command=goto&page=index&message=wrong in catch");
        }
    }
}
