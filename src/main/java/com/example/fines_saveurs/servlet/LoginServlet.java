package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.model.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.example.fines_saveurs.service.AdminService;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        AdminService adminService = new AdminService();
        boolean isLogged = adminService.login(email, password);
        if (isLogged) {
            HttpSession session = req.getSession();
            session.setAttribute("email", email);

            Admin actualAdmin = adminService.getAdminByEmail(email);
            session.setAttribute("actualAdmin", actualAdmin);

            if (actualAdmin != null && actualAdmin.getStatus()) {
                session.setAttribute("admin", actualAdmin);
                session.setAttribute("status", actualAdmin.getStatus());
            }
            resp.sendRedirect("/secured/categories");
        } else {
            req.setAttribute("login_error", true);
            req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
        }
    }
}