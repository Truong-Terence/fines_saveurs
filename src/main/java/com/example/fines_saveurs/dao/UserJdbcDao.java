package com.example.fines_saveurs.dao;

import com.example.fines_saveurs.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserJdbcDao implements UserDao{
    @Override
    public boolean create(User entity) {
        throw new RuntimeException();
    }

    @Override
    public List<User> findAll() {
        throw new RuntimeException();
    }

    @Override
    public User findById(Long aLong) {
        throw new RuntimeException();
    }

    @Override
    public void update(User entity) {
        throw new RuntimeException();
    }

    @Override
    public void delete(User entity) {
        throw new RuntimeException();
    }

    @Override
    public User findByEmail (String email) {
        Connection connection = DataBase.getConnection();
        String query = "SELECT id, email, password FROM admin WHERE email=?";
        User userFound = null;

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, email);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                userFound = new User(
                        result.getLong("id"),
                        result.getString("email"),
                        result.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userFound;
    }
}
