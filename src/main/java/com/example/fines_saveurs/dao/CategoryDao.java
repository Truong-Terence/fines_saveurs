package com.example.fines_saveurs.dao;

import com.example.fines_saveurs.model.Category;

import java.util.List;

public interface CategoryDao extends GenericDao<Category, Integer> {

//    Category findById(Integer id);
//
    Category findByName(String name);

    boolean create(Category entity);

    List<Category> findAll();

    Category findById(Integer id);

    void update(Category entity);

    boolean delete(Category entity);

}
