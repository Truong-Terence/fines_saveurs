package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.service.AdminService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = DeleteAdminServlet.URL)
public class DeleteAdminServlet extends HttpServlet {

    public static final String URL = "/secured/delete-admin";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));

        AdminService adminService = new AdminService();
        adminService.deleteAdmin(id);
        response.sendRedirect(request.getContextPath() + "/secured/admins");
    }
}
