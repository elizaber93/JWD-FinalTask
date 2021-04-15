package by.epam.training.javaWEB.finalTask.controller.command.impl;

import by.epam.training.javaWEB.finalTask.bean.UserDetail;
import by.epam.training.javaWEB.finalTask.controller.command.Command;
import by.epam.training.javaWEB.finalTask.controller.util.Page;
import by.epam.training.javaWEB.finalTask.service.ServiceProvider;
import by.epam.training.javaWEB.finalTask.service.exception.ServiceException;
import by.epam.training.javaWEB.finalTask.service.serviceInterface.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GoToEditProfile implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        int userId=0;
        if ((boolean) session.getAttribute("auth")) {
            userId = (int)session.getAttribute("userId");
        } else {
            response.sendRedirect("Controller?command=goto&page=index&message=you must log in");
        }
        UserService userService = ServiceProvider.getInstance().getUserService();
        UserDetail userDetail = null;
        try {
            userDetail = userService.getUserDetail(userId);
        } catch (ServiceException e) {
            Logger.getLogger(GoToEditProfile.class).info(e);
            response.sendRedirect("Controller?command=goto&page=index&message=wrong");
        }
        request.setAttribute("userDetail", userDetail);
        //response.sendRedirect("Controller?command=goto&page=edit_profile");
        request.getRequestDispatcher(Page.EDIT_PROFILE.getPath()).forward(request,response);

    }
}
