package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.service.AdminService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.fines_saveurs.model.Admin;
import jakarta.servlet.http.HttpSession;

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

        HttpSession session = request.getSession();
        AdminService adminService = new AdminService();
        Admin actualAdmin = adminService.getAdminByEmail((String) session.getAttribute("email"));
        System.out.println(actualAdmin);
        System.out.println(actualAdmin.getStatus());
        if (actualAdmin != null  && actualAdmin.getStatus()) {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");


            try {
                adminService.addAdmin(email, firstname, lastname, password);
                response.sendRedirect("/secured/admins");
                return;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("/secured/admins");
            return;
        }
        System.out.println("AddAdminServlet - actualAdmin: " + actualAdmin);

        response.sendRedirect("/secured/admins");
    }
}
