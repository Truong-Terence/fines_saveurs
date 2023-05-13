package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.service.ImageService;
import com.example.fines_saveurs.util.Image;
import com.example.fines_saveurs.util.Path;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;

@WebServlet(name = "ImageServlet", value = "/secured/image")
public class ImageServlet extends HttpServlet {

    private ImageService service = new ImageService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String imageFileName = request.getParameter("file");
        if (imageFileName.length() == 0) return;
        response.setContentType("image/jpg");

        try (ServletOutputStream out = response.getOutputStream();) {
            service.readImage(imageFileName, out);
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

}
