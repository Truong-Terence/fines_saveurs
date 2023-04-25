package com.example.fines_saveurs.dao;

import com.example.fines_saveurs.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    private Category mapToCategory(ResultSet resultSet) throws SQLException {
//        int id = resultSet.getInt("id_category");
//        String name = resultSet.getString("name");
//
//        System.out.println("id_category: " + category.getId());
//        System.out.println("name: " + category.getName());
//
//        return new Category(id, name);
        Category category = new Category();
        category.setId(resultSet.getInt("id_category"));
        category.setName(resultSet.getString("name"));

        System.out.println("id_category: " + category.getId());
        System.out.println("name: " + category.getName());

        return category;
    }

    public static List<Category> findAll() {
        Connection connection = DataBase.getConnection();
        List<Category> categories = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT id_category, name FROM category")){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                categories.add(new Category(
                        resultSet.getInt("id_category"),
                        resultSet.getString("name")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }
    public boolean create(Category category) {
        Connection connection = DataBase.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO category (name) VALUES (?)")) {
            preparedStatement.setString(1, category.getName());
            int result = preparedStatement.executeUpdate();
            return result == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void delete(Category category) throws SQLException {
        Connection connection = DataBase.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM category WHERE id_category=?")) {
            preparedStatement.setInt(1, category.getId());

            int row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to delete Category");
        }
    }

    public Category getById(Integer id) {
        Connection connection = DataBase.getConnection();
        Category categoryFound = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM category WHERE id_category=?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                categoryFound = mapToCategory(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return categoryFound;
    }
}
