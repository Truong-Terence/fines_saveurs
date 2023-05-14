package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.service.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = DeleteCategoryServlet.URL)
public class DeleteCategoryServlet extends HttpServlet {
    public static final String URL = "/secured/delete-category";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        CategoryService categoryService = new CategoryService();
        categoryService.deleteCategory(id);
        response.sendRedirect(request.getContextPath() + "/secured/categories");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
