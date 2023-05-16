package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.model.Category;
import com.example.fines_saveurs.model.Product;
import com.example.fines_saveurs.service.CategoryService;
import com.example.fines_saveurs.service.ImageService;
import com.example.fines_saveurs.service.ProductService;
import com.example.fines_saveurs.util.DataHandler;
import com.example.fines_saveurs.util.GenerateShortUUID;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;

@WebServlet(name = "EditProductServlet", value = "/secured/edit-product")
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

        // Get input values
        int id = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("product-name");
        String brand = request.getParameter("brand");

        int stock = DataHandler.parseParam(
                request.getParameter("stock"), Integer.class);

        String description = request.getParameter("description");
        String ingredients = request.getParameter("ingredients");
        String conditioning = request.getParameter("conditioning");
        String origin = request.getParameter("origin");

        double price = DataHandler.parseParam(
                request.getParameter("price"), Double.class);

        int categoryId = DataHandler.parseParam(
                request.getParameter("category"), Integer.class);

        // Update product data
        new ProductService().updateProduct(id, name, brand, stock, description, ingredients, conditioning, origin, price, categoryId);

        response.sendRedirect("/secured/products");
    }
}
