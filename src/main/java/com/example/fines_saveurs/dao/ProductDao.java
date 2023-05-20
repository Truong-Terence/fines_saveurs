package com.example.fines_saveurs.dao;

import com.example.fines_saveurs.model.Category;
import com.example.fines_saveurs.model.Product;

import java.util.List;

public interface ProductDao extends GenericDao<Product, Integer> {

    public List<Product> findByCategory(int categoryId);
    public boolean updateImage(int productId, String filename);
}
