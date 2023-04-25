package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.service.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = DeleteCategoryServlet.URL)
public class DeleteCategoryServlet extends HttpServlet {
    public static final String URL = "/delete-category";
    private final Logger logger = Logger.getLogger(DeleteCategoryServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id_category");
        logger.log(Level.INFO, "Id_category received: " + id);
        if ("DELETE".equals(request.getMethod())) {
            try {
                new CategoryService().deleteCategoryById(Integer.parseInt(id));
                response.sendRedirect(request.getContextPath() + "/categories");
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect(request.getContextPath() + DeleteCategoryServlet.URL + "?error=true");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
