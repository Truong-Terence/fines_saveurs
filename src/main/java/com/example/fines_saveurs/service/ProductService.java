package com.example.fines_saveurs.service;

import com.example.fines_saveurs.dao.ProductJdbcDao;
import com.example.fines_saveurs.model.Category;
import com.example.fines_saveurs.model.Product;

import java.util.List;


public class ProductService {

    private final ProductJdbcDao productDao = new ProductJdbcDao();

    public boolean addProduct(String name, String brand, String ref, int stock, String description, String ingredients, String conditioning, String origin, double price, String fileName, Category category) {
        Product newProduct = new Product(name, brand, ref, stock, fileName, description, ingredients, conditioning, origin, price, category);
        return productDao.create(newProduct);
    }

    public List<Product> fetchAllProducts() {
        return productDao.findAll();
    }
}
