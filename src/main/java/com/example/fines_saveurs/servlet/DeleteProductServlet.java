package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(urlPatterns = DeleteProductServlet.URL)
public class  DeleteProductServlet extends HttpServlet {
    public static final String URL = "/secured/delete-product";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductService productService = new ProductService();
        productService.deleteProduct(id);
        response.sendRedirect(request.getContextPath() + "/secured/products");
    }

}
