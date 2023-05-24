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
        String query = "INSERT INTO flavour.admin (email, firstname, lastname, password) VALUES (?,?,?,?);";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, admin.getEmail());
            pst.setString(2, admin.getFirstname());
            pst.setString(3, admin.getLastname());
            pst.setString(4, admin.getPassword());
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
        String query = "SELECT id, email, password FROM admin WHERE email=?";

        Admin adminFound = null;

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, email);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                adminFound = new Admin(
                        result.getLong("id"),

                        result.getString("email"),
                        result.getString("password")
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
                admins.add(new Admin(id, email, password));
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return admins;
    }
}
