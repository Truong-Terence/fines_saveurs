package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.model.Category;
import com.example.fines_saveurs.service.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CategoryDetailsServlet", value = "/secured/category-details")
public class CategoryDetailsServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("id"));
        Category category = new CategoryService().getById(categoryId);
        request.setAttribute("category", category);
        request.getRequestDispatcher("/WEB-INF/category-details.jsp").forward(request, response);
    }
}
