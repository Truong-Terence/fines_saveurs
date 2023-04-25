package com.example.fines_saveurs.dao;

import com.example.fines_saveurs.model.User;

public interface UserDao extends GenericDao <User, Long> {
    User findByEmail(String email);
}
