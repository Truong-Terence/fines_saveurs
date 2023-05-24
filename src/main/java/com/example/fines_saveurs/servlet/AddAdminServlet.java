package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.service.AdminService;
import com.example.fines_saveurs.service.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AddAdminServlet", value = "/secured/add-admin")
@MultipartConfig
public class AddAdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request
                .getRequestDispatcher("/WEB-INF/add-admin.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String password = request.getParameter("password");


        try {
            AdminService adminService= new AdminService();
            adminService.addAdmin(email, firstname, lastname, password);
            response.sendRedirect("/secured/admins");
            return;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/secured/admins");
    }
}
