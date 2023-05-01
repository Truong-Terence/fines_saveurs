package com.example.fines_saveurs.dao;

import com.example.fines_saveurs.model.Product;

import java.sql.*;
import java.util.List;

public class ProductJdbcDao implements ProductDao {

    private final Connection connection = DataBase.getConnection();

    @Override
    public boolean create(Product entity) {
        boolean success = false;
        String query = "INSERT INTO product (name, brand, reference, stock, image_url, description, ingredient, conditioning, origin, price, id_category) " +
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
            System.out.println(pst);
            pst.executeUpdate();
            success = true;
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return success;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product findById(Long aLong) {
        return null;
    }

    @Override
    public void update(Product entity) {

    }

    @Override
    public void delete(Product entity) {

    }
}
