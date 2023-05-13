package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.model.Category;
import com.example.fines_saveurs.service.CategoryService;
import com.example.fines_saveurs.service.ImageService;
import com.example.fines_saveurs.service.ProductService;
import com.example.fines_saveurs.util.DataHandler;
import com.example.fines_saveurs.util.GenerateShortUUID;

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

        int stock = DataHandler.parseParam(
                request.getParameter("stock"), Integer.class);

        String description = request.getParameter("description");
        String ingredients = request.getParameter("ingredients");

        String conditioning = DataHandler.parseParam(
                request.getParameter("conditioning"), String.class);

        String origin = request.getParameter("origin");

        double price = DataHandler.parseParam(
                request.getParameter("price"), Double.class);

        int categoryId = DataHandler.parseParam(
                request.getParameter("category"), Integer.class);
        if (categoryId == 0) categoryId = 1; // Default category: undefined
        Category category = new Category(categoryId);

        String ref = GenerateShortUUID.next(6);

        // Get image uploaded from the form
        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        // Save image in the app in product-images
        if (fileName.length() > 0) {
            InputStream fileContent = filePart.getInputStream();
            new ImageService().saveImage(fileContent, fileName);
        }

        // Send data to insert in the database
        new ProductService().addProduct(name, brand, ref, stock, description, ingredients, conditioning, origin, price, fileName, category);

        response.sendRedirect("/secured/products");
    }
}
