package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.dao.ProductDao;
import com.example.fines_saveurs.service.ProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet(name = "ShowImagesServlet", value = "/secured/show-images")
public class ShowImagesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in show images servlet");
        List<InputStream> images = new ProductService().getImages();
        System.out.println(images);
        request.setAttribute("images", images);
        request
                .getRequestDispatcher("/WEB-INF/show-images.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
