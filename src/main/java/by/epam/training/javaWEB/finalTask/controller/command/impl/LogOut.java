package by.epam.training.javaWEB.finalTask.controller.command.impl;

import by.epam.training.javaWEB.finalTask.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogOut implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {

        HttpSession session = request.getSession();

        if(session != null) {
            session.removeAttribute("auth");
            session.removeAttribute("userID");
            session.removeAttribute("role");
        }

        response.sendRedirect("Controller?command=goto&page=index&message=logout ok");

    }
}
