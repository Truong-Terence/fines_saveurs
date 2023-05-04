package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.model.Category;
import com.example.fines_saveurs.model.Product;
import com.example.fines_saveurs.service.ProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductsServlet", urlPatterns = {"/secured/products"})
public class ProductsServlet extends HttpServlet {

    public static final String URL = "/products";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryId = request.getParameter("category_id");
        List<Product> products;
        if (categoryId == null) {
            products = new ProductService().fetchAllProducts();
        } else {
            String catName = request.getParameter("category_name");
            int catId = Integer.parseInt(categoryId);
            products = new ProductService().fetchProductsByCategory(catId);
            request.setAttribute("category", new Category(catId, catName));
        }
        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INF/products.jsp").forward(request, response);
    }

}
