package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.service.ImageService;
import com.example.fines_saveurs.service.ProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

@WebServlet(name = "EditImageServlet", value = "/secured/edit-image")
@MultipartConfig
public class EditImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("productId", request.getParameter("id"));
        request
                .getRequestDispatcher("/WEB-INF/edit-image.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get input values
        int id = Integer.parseInt(request.getParameter("id"));

        // Get image uploaded from the form
        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        // Save image in the app in product-images
        if (fileName.length() > 0) {
            InputStream fileContent = filePart.getInputStream();
            new ImageService().saveImage(fileContent, fileName);
        }

        // Amend the image name in the database
        new ProductService().changeImage(id, fileName);

        response.sendRedirect("/secured/product-details?id=" + id);
    }
}
