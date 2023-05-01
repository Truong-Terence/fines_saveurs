package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.model.Category;
import com.example.fines_saveurs.service.CategoryService;
import com.example.fines_saveurs.service.ProductService;
import com.example.fines_saveurs.util.Image;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;

import jakarta.servlet.http.Part;


@WebServlet(name = "AddProductServlet", value = "/secured/add-product")
@MultipartConfig
public class AddProductServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = new CategoryService().fetchAllCategories();
        req.setAttribute("categories", categories);
        req
                .getRequestDispatcher("/WEB-INF/add-product.jsp")
                .forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get input values
        String name = request.getParameter("product-name");
        String brand = request.getParameter("brand");
        String ref = request.getParameter("ref");
        int stock = Integer.parseInt(request.getParameter("stock"));
        String description = request.getParameter("description");
        String ingredients = request.getParameter("ingredients");
        String conditioning = request.getParameter("conditioning");
        String origin = request.getParameter("origin");
        double price = Double.parseDouble(request.getParameter("price"));
        int categoryId = Integer.parseInt(request.getParameter("category"));

        Category category = new Category(categoryId);

        // Get image uploaded from the form
        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        InputStream fileContent = filePart.getInputStream();

        // Save image in the app in /webapp/images/products
        new Image().saveImage(fileContent, fileName);

        // Send data to insert in the database
        new ProductService().addProduct(name, brand, ref, stock, description, ingredients, conditioning, origin, price, fileName, category);

        response.sendRedirect("/secured/products");
    }
}
