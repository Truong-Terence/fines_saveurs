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

    public List<Product> fetchProductsByCategory(int categoryId) {
        return productDao.findByCategory(categoryId);
    }

    public Product fetchProductById(int id) {
        return productDao.findById(id);
    }

    public boolean deleteProduct(int id) {
        return productDao.delete(new Product(id));
    }

    public Product updateProduct(int id, String name, String brand, int stock, String description, String ingredients, String conditioning, String origin, double price, int categoryId) {
        Category category = new Category(categoryId);
        Product product = new Product(id, name, brand, stock, description, ingredients, conditioning, origin, price, category);
        productDao.update(product);
        return productDao.findById(id);
    }

    public List<Product> searchByKeywords(String keywords) {
        String[] keywordsArray = keywords.split(" ");
        List<Product> posts = productDao.fetchByKeywords(keywordsArray);
        return posts;
    }

}
