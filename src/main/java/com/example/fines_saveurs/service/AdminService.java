package com.example.fines_saveurs.service;

import com.example.fines_saveurs.dao.AdminDao;
import com.example.fines_saveurs.dao.AdminJdbcDao;
import com.example.fines_saveurs.model.Admin;

public class AdminService {
    private AdminDao adminDao = new AdminJdbcDao();
    public boolean login(String email, String password) {
        Admin adminFound = adminDao.findByEmail(email);
        if (adminFound != null) {
            return adminFound.getPassword().equals(password);
        }
        return false;
    }
}
