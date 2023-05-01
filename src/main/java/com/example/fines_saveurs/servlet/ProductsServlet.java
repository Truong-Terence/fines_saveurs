package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.model.Product;
import com.example.fines_saveurs.service.ProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductsServlet", urlPatterns = {"/secured/products"})
public class ProductsServlet extends HttpServlet {

    public static final String URL = "/products";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> allProducts = new ProductService().fetchAllProducts();
        request.setAttribute("products", allProducts);
        request.getRequestDispatcher("/WEB-INF/products.jsp").forward(request, response);
    }

}
