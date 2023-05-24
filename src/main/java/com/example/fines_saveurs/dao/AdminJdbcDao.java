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
    public Admin findById(Long aLong) {
        throw new RuntimeException();
    }

    @Override
    public void update(Admin entity) {
        throw new RuntimeException();
    }

    @Override
    public boolean delete(Admin entity) {
        throw new RuntimeException();
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
                admins.add(new Admin(id, email, password, firstname, lastname));
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return admins;
    }
}
