package com.example.fines_saveurs.dao;

import com.example.fines_saveurs.model.Category;
import com.example.fines_saveurs.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductJdbcDao implements ProductDao {

    private final Connection connection = DataBase.getConnection();

    @Override
    public boolean create(Product entity) {
        boolean success = false;
        String query = "INSERT INTO product (name, brand, reference, stock, image_url, description, ingredient, conditioning, origin, price, id) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?);";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, entity.getName());
            pst.setString(2, entity.getBrand());
            pst.setString(3, entity.getReference());
            pst.setInt(4, entity.getStock());
            pst.setString(5, entity.getImageUrl());
            pst.setString(6, entity.getDescription());
            pst.setString(7, entity.getIngredient());
            pst.setString(8, entity.getConditioning());
            pst.setString(9, entity.getOrigin());
            pst.setDouble(10, entity.getPrice());
            pst.setInt(11, entity.getCategory().getId());
            pst.executeUpdate();
            success = true;
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return success;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM product";
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String brand = result.getString("brand");
                String ref = result.getString("reference");
                int stock = result.getInt("stock");
                String imageUrl = result.getString("image_url");
                String description = result.getString("description");
                String ingredients = result.getString("ingredient");
                String conditioning = result.getString("conditioning");
                String origin = result.getString("origin");
                double price = result.getDouble("price");
                Category cat = new Category(result.getInt("id_category"));
                Product prod = new Product(id, name, brand, ref, stock, imageUrl, description, ingredients, conditioning, origin, price, cat);
                products.add(prod);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return products;
    }

    @Override
    public Product findById(Integer id) {
        Product prod = new Product();
        String query = "SELECT * FROM product WHERE id = ?";

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                prod.setId(result.getInt("id"));
                prod.setName(result.getString("name"));
                prod.setBrand(result.getString("brand"));
                prod.setReference(result.getString("reference"));
                prod.setStock(result.getInt("stock"));
                prod.setImageUrl(result.getString("image_url"));
                prod.setDescription(result.getString("description"));
                prod.setIngredient(result.getString("ingredient"));
                prod.setConditioning(result.getString("conditioning"));
                prod.setOrigin(result.getString("origin"));
                prod.setPrice(result.getDouble("price"));
                prod.setCategory(new Category(result.getInt("id_category")));
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return prod;
    }

    @Override
    public List<Product> findByCategory(int categoryId) {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM product WHERE id_category = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, categoryId);
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                Product prod = new Product();
                prod.setId(result.getInt("id"));
                prod.setName(result.getString("name"));
                prod.setBrand(result.getString("brand"));
                prod.setReference(result.getString("reference"));
                prod.setStock(result.getInt("stock"));
                prod.setImageUrl(result.getString("image_url"));
                prod.setDescription(result.getString("description"));
                prod.setIngredient(result.getString("ingredient"));
                prod.setConditioning(result.getString("conditioning"));
                prod.setOrigin(result.getString("origin"));
                prod.setPrice(result.getDouble("price"));
                prod.setCategory(new Category(result.getInt("id_category")));
                products.add(prod);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return products;
    }


    @Override
    public void update(Product entity) {

    }

    @Override
    public boolean delete(Product entity) {
        return false;
    }

}
