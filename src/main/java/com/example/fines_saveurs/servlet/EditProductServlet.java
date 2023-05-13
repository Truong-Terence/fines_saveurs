package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.model.Category;
import com.example.fines_saveurs.model.Product;
import com.example.fines_saveurs.service.CategoryService;
import com.example.fines_saveurs.service.ProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EditProductServlet", value = "/edit-product")
public class EditProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = new ProductService().fetchProductById(id);
        request.setAttribute("product", product);
        List<Category> categories = new CategoryService().fetchAllCategories();
        request.setAttribute("categories", categories);
        request
                .getRequestDispatcher("/WEB-INF/edit-product.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
