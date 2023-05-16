package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.dao.CategoryDao;
import com.example.fines_saveurs.dao.CategoryJdbcDao;
import com.example.fines_saveurs.model.Category;
import com.example.fines_saveurs.service.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = CategoryUpdateServlet.URL)
public class CategoryUpdateServlet extends HttpServlet {

    public static final String URL = "/secured/edit-category";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = new CategoryService().getById(id);
        request.setAttribute("category", category);

        request.getRequestDispatcher("/WEB-INF/edit-category.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        CategoryService categoryService = new CategoryService();
        Category category = categoryService.getById(id);

        if (category != null) {
            category.setName(name);
            categoryService.updateCategory(category);
        }

        response.sendRedirect("/secured/categories");
    }
}
