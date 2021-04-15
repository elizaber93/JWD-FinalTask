package by.epam.training.javaWEB.finalTask.controller.command.impl;

import by.epam.training.javaWEB.finalTask.bean.UserDetail;
import by.epam.training.javaWEB.finalTask.controller.command.Command;
import by.epam.training.javaWEB.finalTask.service.ServiceProvider;
import by.epam.training.javaWEB.finalTask.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

public class SaveUserDetail implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        int userId = (int)session.getAttribute("userId");
        UserDetail userDetail = new UserDetail();
        userDetail.setUserId(userId);
        userDetail.setFirstName(request.getParameter("firstname"));
        userDetail.setLastName(request.getParameter("lastname"));
        userDetail.setPhone(request.getParameter("phone"));
        userDetail.setEmail(request.getParameter("email"));
        userDetail.setAddress(request.getParameter("address"));
        try {
            ServiceProvider.getInstance().getUserService().updateUserDetail(userId,userDetail);
        } catch (ServiceException e) {
            response.sendRedirect("Controller?command=goto_edit_profile&message=wrong");
        }
        response.sendRedirect("Controller?command=goto_edit_profile&message=saveOk");
    }
}
