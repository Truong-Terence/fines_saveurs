package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.model.Admin;
import com.example.fines_saveurs.model.Category;
import com.example.fines_saveurs.service.AdminService;
import com.example.fines_saveurs.service.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "EditAdminServlet", value = "/secured/edit-admin")
public class EditAdminServlet extends HttpServlet {

    private final AdminService adminService = new AdminService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        long id = Long.parseLong(idParam);
        Admin admin = adminService.fetchAdminById(id);
        request.setAttribute("admin", admin);
        request.getRequestDispatcher("/WEB-INF/edit-admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean status = request.getParameter("status") != null;
        Admin admin = adminService.fetchAdminById(id);

        if (admin != null) {
            admin.setFirstname(firstname);
            admin.setLastname(lastname);
            admin.setEmail(email);
            admin.setPassword(password);
            admin.setStatus(status);
            adminService.updateAdmin(admin);
        }

        response.sendRedirect(request.getContextPath() + "/secured/admins");
    }
}

