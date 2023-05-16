package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.dao.CategoryDao;
import com.example.fines_saveurs.model.Category;
import com.example.fines_saveurs.service.CategoryService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/secured/categories")
public class CategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService service = new CategoryService();

        List<Category> categories = service.fetchAllCategories();
        request.setAttribute("categories", categories);

        List<Category> emptyCategories = service.fetchEmptyCategories();
        request.setAttribute("emptyCategories", emptyCategories);

        request.getRequestDispatcher("/WEB-INF/categories.jsp").forward(request, response);
    }

}