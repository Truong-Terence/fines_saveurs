package com.example.fines_saveurs.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.example.fines_saveurs.service.UserService;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private static final String LOGIN_JSP = "/WEB-INF/home";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(LOGIN_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        UserService userService = new UserService();
        boolean isLogged = userService.login(email, password);
        if(isLogged){
            HttpSession session = req.getSession();
            session.setAttribute("email", email);
            resp.sendRedirect(req.getContextPath() + ProductsServlet.URL);
        }else {
            req.setAttribute("login_error", true);
            req.getRequestDispatcher(LOGIN_JSP).forward(req, resp);
        }
    }
}
