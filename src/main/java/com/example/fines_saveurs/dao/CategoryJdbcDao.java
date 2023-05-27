package com.example.fines_saveurs.dao;

import com.example.fines_saveurs.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryJdbcDao implements CategoryDao{
    private  final Connection connection = DataBase.getConnection();

    @Override
    public boolean create(Category category) {
        boolean success = false;
        String query = "INSERT INTO category (name) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, category.getName());
            preparedStatement.executeUpdate();
//            success = true;
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                category.setId(generatedKeys.getInt(1));
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
    @Override
    public List<Category> findAll() {
        String query = "SELECT id, name FROM category";
        List<Category> categories = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                categories.add(new Category(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }
    @Override
    public Category findById(Integer id) {
        Category category = null;
        String query = "SELECT * FROM category WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                category = new Category(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return category;
    }

    @Override
    public Category findByName(String name) {
        Category category = null;
        String query = "SELECT * FROM category WHERE name = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                category = new Category(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }


    @Override
    public void update(Category category) {
        String query = "UPDATE category SET name=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, category.getName());
            statement.setInt(2, category.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating category", e);
        }
    }

    @Override
    public boolean delete(Category category) {
        String query = "DELETE FROM category WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, category.getId());

            int row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to delete Category");
        }
        return false;
    }

    public List<Category> fetchEmptyCategories() {
        String query = "SELECT c.id, c.name, p.id_category " +
                "FROM flavour.category c " +
                "LEFT OUTER JOIN flavour.product p " +
                "ON c.id = p.id_category " +
                "WHERE p.id_category IS NULL; ";
        List<Category> list = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                Category category = new Category();
                category.setId(result.getInt(1));
                category.setName(result.getString(2));
                list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Category> fetchNotEmptyCategories() {
        String query = "SELECT DISTINCT c.id, c.name " +
                "FROM flavour.category c " +
                "INNER JOIN flavour.product p " +
                "ON c.id = p.id_category;";
        List<Category> list = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                Category category = new Category();
                category.setId(result.getInt(1));
                category.setName(result.getString(2));
                list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
