package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;


@WebServlet(name = "AddProductServlet", value = "/secured/add-product")
public class AddProductServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req
                .getRequestDispatcher("/WEB-INF/add-product.jsp")
                .forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("in post method");
        try {
            File image = new File(req.getParameter("file"));
            System.out.println(image.getAbsolutePath());
            //InputStream imageStream = new FileInputStream("C:\\Users\\chana\\Pictures\\louhans-2502340759.jpg");
            InputStream imageStream = new FileInputStream(image.getCanonicalPath());
            new ProductService().saveImage(imageStream);
        } catch (FileNotFoundException error) {
            error.printStackTrace();
        }
        resp.sendRedirect("show-images");
    }
}
