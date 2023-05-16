package com.example.fines_saveurs.dao;

import com.example.fines_saveurs.model.Category;
import com.example.fines_saveurs.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductJdbcDao implements ProductDao {

    private final Connection connection = DataBase.getConnection();

    @Override
    public boolean create(Product entity) {
        String query = "INSERT INTO flavour.product (name, brand, reference, stock, image_url, description, ingredient, conditioning, origin, price, id_category) " +
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
            int row = pst.executeUpdate();
            if (row == 1) {
                return true;
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String query = "" +
                "SELECT p.id AS 'id', p.name AS 'name', p.brand AS 'brand', p.reference AS 'reference', p.price AS 'price', p.conditioning AS 'conditioning', p.description AS 'description', p.ingredient AS 'ingredient', p.origin AS 'origin', p.stock AS 'stock', p.image_url AS 'image_url', p.id_category AS 'id_category', c.name AS 'name_category' " +
                "FROM flavour.product p " +
                "INNER JOIN flavour.category c " +
                "ON p.id_category = c.id;";
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
                Category cat = new Category(
                        result.getInt("id_category"),
                        result.getString("name_category")
                );
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
        String query = "" +
                "SELECT p.id AS 'id', p.name AS 'name', p.brand AS 'brand', p.reference AS 'reference', p.price AS 'price', p.conditioning AS 'conditioning', p.description AS 'description', p.ingredient AS 'ingredient', p.origin AS 'origin', p.stock AS 'stock', p.image_url AS 'image_url', p.id_category AS 'id_category', c.name AS 'name_category' " +
                "FROM flavour.product p " +
                "INNER JOIN flavour.category c " +
                "ON p.id_category = c.id " +
                "WHERE p.id = ?";
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
                prod.setCategory(new Category(
                        result.getInt("id_category"),
                        result.getString("name_category")
                ));
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return prod;
    }

    @Override
    public List<Product> findByCategory(int categoryId) {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM flavour.product WHERE id_category = ?";
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
        String query = "" +
                "UPDATE flavour.product " +
                "SET name = ?, brand = ?, stock = ?, description = ?, ingredient = ?, conditioning = ?, origin = ?, price = ?, id_category = ? " +
                "WHERE id = ?;";
        try (PreparedStatement pst = connection.prepareStatement(query);) {
            pst.setString(1, entity.getName());
            pst.setString(2, entity.getBrand());
            pst.setInt(3, entity.getStock());
            pst.setString(4, entity.getDescription());
            pst.setString(5, entity.getIngredient());
            pst.setString(6, entity.getConditioning());
            pst.setString(7, entity.getOrigin());
            pst.setDouble(8, entity.getPrice());
            pst.setInt(9, entity.getCategory().getId());
            pst.setInt(10, entity.getId());
            pst.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

    @Override
    public boolean delete(Product product) {
        String query = "DELETE FROM flavour.product WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, product.getId());
            int row = preparedStatement.executeUpdate();
            if (row == 1) return true;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to delete Product");
        }
        return false;
    }

}
