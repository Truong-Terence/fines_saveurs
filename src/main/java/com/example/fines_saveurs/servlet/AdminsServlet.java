package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.model.Admin;
import com.example.fines_saveurs.service.AdminService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminsServlet", urlPatterns = {"/secured/admins"})
public class AdminsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Admin> admins;
        admins = new AdminService().fetchAllAdmins();
        request.setAttribute("admins", admins);
        request.getRequestDispatcher("/WEB-INF/admins.jsp").forward(request, response);
    }
}
