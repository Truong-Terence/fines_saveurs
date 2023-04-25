package com.example.fines_saveurs.dao;

import com.example.fines_saveurs.model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdminJdbcDao implements AdminDao {
    @Override
    public boolean create(Admin entity) {
        throw new RuntimeException();
    }

    @Override
    public List<Admin> findAll() {
        throw new RuntimeException();
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
    public void delete(Admin entity) {
        throw new RuntimeException();
    }

    @Override
    public Admin findByEmail (String email) {
        Connection connection = DataBase.getConnection();
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
}
