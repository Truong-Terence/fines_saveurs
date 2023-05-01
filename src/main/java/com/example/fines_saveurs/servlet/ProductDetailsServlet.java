package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.model.Product;
import com.example.fines_saveurs.service.ProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ProductDetailsServlet", value = "/secured/product-details")
public class ProductDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));
        Product prod = new ProductService().fetchProductById(productId);
        request.setAttribute("produit", prod);
        request.getRequestDispatcher("/WEB-INF/product-details.jsp").forward(request, response);
    }
}
