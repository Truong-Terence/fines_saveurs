package com.example.fines_saveurs.servlet;


import com.example.fines_saveurs.model.Category;
import com.example.fines_saveurs.service.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import com.example.fines_saveurs.dao.CategoryDao;

@WebServlet(urlPatterns = AddCategoryServlet.URL)
public class AddCategoryServlet extends HttpServlet {

    public static final String URL = "/add-category";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = CategoryDao.findAll();
        request.setAttribute("categories", categories);

        request.getRequestDispatcher("/WEB-INF/add-category.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        try {
            new CategoryService().createCategory(name);
            response.sendRedirect("categories");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + AddCategoryServlet.URL + "?error=true");
        }
    }
}

