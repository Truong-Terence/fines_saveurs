package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.util.Path;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "ImageServlet", value = "/secured/image")
public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpg");
        ServletOutputStream out;
        out = response.getOutputStream();
        String origin = new Path().getProjectPath() + "/product-images/" + request.getParameter("file");
        FileInputStream fin = new FileInputStream(origin);

        BufferedInputStream bin = new BufferedInputStream(fin);
        BufferedOutputStream bout = new BufferedOutputStream(out);
        int ch =0;
        while((ch=bin.read())!=-1) {
            bout.write(ch);
        }

        bin.close();
        fin.close();
        bout.close();
        out.close();
    }

}
