package com.example.fines_saveurs.dao;

import com.example.fines_saveurs.model.Admin;
import com.example.fines_saveurs.model.Category;
import com.example.fines_saveurs.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminJdbcDao implements AdminDao {

    private final Connection connection = DataBase.getConnection();

    @Override
    public boolean create(Admin admin) {
        String query = "INSERT INTO flavour.admin (email, firstname, lastname, password, status) VALUES (?,?,?,?,?);";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, admin.getEmail());
            pst.setString(2, admin.getFirstname());
            pst.setString(3, admin.getLastname());
            pst.setString(4, admin.getPassword());
            pst.setBoolean(5, admin.getStatus());
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
    public Admin findById(Long id) {
        Admin admin = new Admin();
        String query = "SELECT * FROM flavour.admin WHERE id=?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setLong(1, id);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                admin.setId((long) result.getInt("id"));
                admin.setFirstname(result.getString("firstname"));
                admin.setLastname(result.getString("lastname"));
                admin.setEmail(result.getString("email"));
                admin.setPassword(result.getString("password"));
                admin.setStatus(result.getBoolean("status"));
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return admin;
    }

    @Override
    public void update(Admin admin) {
        String query = "UPDATE admin SET firstname=?, lastname=?, email=?, password=?, status=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, admin.getFirstname());
            statement.setString(2, admin.getLastname());
            statement.setString(3, admin.getEmail());
            statement.setString(4, admin.getPassword());
            statement.setBoolean(5, admin.getStatus());
            statement.setLong(6, admin.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating admin", e);
        }
    }

    @Override
    public boolean delete(Admin admin) {
        String query = "DELETE FROM admin WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, Math.toIntExact(admin.getId()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Impossible de supprimer l'administrateur");
        }
        return false;
    }

    @Override
    public Admin findByEmail (String email) {
        String query = "SELECT id, email, password, status FROM admin WHERE email=?";

        Admin adminFound = null;

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, email);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                adminFound = new Admin(
                        result.getLong("id"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getBoolean("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminFound;
    }

    @Override
    public List<Admin> findAll() {
        List<Admin> admins = new ArrayList<>();
        String query = "SELECT * FROM admin";
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                Long id = result.getLong("id");
                String email = result.getString("email");
                String password = result.getString("password");
                String firstname = result.getString("firstname");
                String lastname = result.getString("lastname");
                Boolean status = result.getBoolean("status");
                admins.add(new Admin(id, email, password, firstname, lastname, status));
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return admins;
    }
}
