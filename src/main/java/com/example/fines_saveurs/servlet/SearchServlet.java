package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.model.Product;
import com.example.fines_saveurs.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", value = "/secured/search")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keywords = request.getParameter("keywords");
        List<Product> productsFound = new ProductService().searchByKeywords(keywords);
        request.setAttribute("products", productsFound);
        request.setAttribute("keywords", keywords);
        request.getRequestDispatcher("/WEB-INF/products.jsp").forward(request, response);
    }

}
