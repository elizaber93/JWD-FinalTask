package by.epam.training.javaWEB.finalTask.controller.command.impl;

import by.epam.training.javaWEB.finalTask.bean.Role;
import by.epam.training.javaWEB.finalTask.bean.User;
import by.epam.training.javaWEB.finalTask.bean.UserDetail;
import by.epam.training.javaWEB.finalTask.controller.command.Command;
import by.epam.training.javaWEB.finalTask.dao.DAOProvider;
import by.epam.training.javaWEB.finalTask.dao.daoInterface.UserDAO;
import by.epam.training.javaWEB.finalTask.dao.daoInterface.UserDetailDAO;
import by.epam.training.javaWEB.finalTask.dao.impl.Parameter;
import by.epam.training.javaWEB.finalTask.service.ServiceProvider;
import by.epam.training.javaWEB.finalTask.service.exception.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUser implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setId(Integer.parseInt(request.getParameter("id")));
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        user.setRole(Integer.parseInt(request.getParameter("role")));
        user.setStatus(Integer.parseInt(request.getParameter("status")));
        UserDetail userDetail = new UserDetail();
        userDetail.setFirstName(request.getParameter("firstname"));
        userDetail.setLastName(request.getParameter("lastname"));
        userDetail.setPhone(request.getParameter("phone"));
        userDetail.setEmail(request.getParameter("email"));
        userDetail.setAddress(request.getParameter("address"));
        userDetail.setUserId(user.getId());

        user.setUserDetail(userDetail);
        try {
            ServiceProvider.getInstance().getUserService().updateUser(user.getId(), user);
            response.sendRedirect("Controller?command=see_users&message=ok");
        } catch (ServiceException e) {
            Logger.getLogger(UpdateUser.class).info(e);
            response.sendRedirect("Controller?command=see_users&message=error");
        }


    }
}
