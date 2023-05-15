package com.example.fines_saveurs.servlet;

import com.example.fines_saveurs.dao.CategoryDao;
import com.example.fines_saveurs.dao.CategoryJdbcDao;
import com.example.fines_saveurs.model.Category;
import com.example.fines_saveurs.service.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = DeleteCategoryServlet.URL)
public class CategoryUpdateServlet extends HttpServlet {

    public static final String URL = "/secured/update-category";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        CategoryService categoryService = new CategoryService();
        categoryService.updateCategory(id);

        // Mettre la catégorie dans l'attribut "category" de la requête
        request.setAttribute("category", category);

        // Afficher le formulaire de mise à jour
        request.getRequestDispatcher("/category-update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer les données du formulaire
        int categoryId = Integer.parseInt(request.getParameter("id"));
        String categoryName = request.getParameter("name");

        // Valider les entrées
        if (categoryName == null || categoryName.trim().isEmpty()) {
            // Si le nom de catégorie est vide, afficher une erreur
            request.setAttribute("error", "Le nom de catégorie ne peut pas être vide");
            request.getRequestDispatcher("/category-update.jsp").forward(request, response);
            return;
        }

        // Mettre à jour la catégorie dans la base de données
        CategoryDao categoryDao = new CategoryJdbcDao();
        Category category = new Category(categoryId, categoryName);
        categoryDao.update(category);

        // Rediriger vers la page d'affichage des catégories
        response.sendRedirect(request.getContextPath() + "/category");
    }
}
