package com.example.fines_saveurs.service;

import com.example.fines_saveurs.dao.CategoryDao;
import com.example.fines_saveurs.model.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {
    private final CategoryDao categoryDao = new CategoryDao();

    public List<Category> fetchAllCategories() {
        return CategoryDao.findAll();
    }
    public Category getById(Integer id) { return categoryDao.getById(id); }
    public boolean createCategory(String name) {
        Category categoryToCreate = new Category(name);
        categoryToCreate.setName(name);
        return categoryDao.create(categoryToCreate);
    }

    public void deleteCategoryById(int id) throws SQLException {
        Category category = getById(id);
        if (category != null) {
            categoryDao.delete(category);
        }
    }

}
