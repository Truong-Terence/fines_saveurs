package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.service.ProductService;
import com.example.fines_saveurs.util.Image;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Arrays;


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

        String imagePath = "";

        try {
            File projectDir = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getParentFile().getParentFile();
            imagePath = new File(projectDir + "/src/main/webapp/images/products/test4.jpg").toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        int[][] imageData = Image.imgToTwoD("C:\\Users\\chana\\Pictures\\louhans-2502340759.jpg");
        Image.twoDToImage(imageData, imagePath);
    }





    /*
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("in post method");
        try {
            File image = new File(req.getParameter("file"));
            System.out.println(image.getAbsolutePath());

            InputStream is = new FileInputStream("C:\\Users\\chana\\Pictures\\louhans-2502340759.jpg");

            InputStream imageStream = new FileInputStream(image.getCanonicalPath());
            String realPath = getServletContext().getRealPath("/images/products/" + req.getParameter("louhans-2502340759.jpg"));

            OutputStream os = new FileOutputStream(realPath);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }

            new ProductService().saveImage(is);
        } catch (FileNotFoundException error) {
            error.printStackTrace();
        }
        resp.sendRedirect("show-images");
    }

     */

}
