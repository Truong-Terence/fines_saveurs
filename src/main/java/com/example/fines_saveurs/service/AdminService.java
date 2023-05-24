package com.example.fines_saveurs.service;

import com.example.fines_saveurs.dao.AdminDao;
import com.example.fines_saveurs.dao.AdminJdbcDao;
import com.example.fines_saveurs.dao.ProductJdbcDao;
import com.example.fines_saveurs.model.Admin;
import com.example.fines_saveurs.model.Category;
import com.example.fines_saveurs.model.Product;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public class AdminService {
    private final AdminJdbcDao adminDao = new AdminJdbcDao();

    public boolean login(String email, String password) {
        Admin adminFound = adminDao.findByEmail(email);
        if (adminFound != null) {
            return adminFound.getPassword().equals(password);
        }
        return false;
    }

    public boolean addAdmin(String email, String password, String firstname, String lastname) {
        Admin newAdmin = new Admin(email, password, firstname, lastname);
        return adminDao.create(newAdmin);
    }

    public List<Admin> fetchAllAdmins() {
        return adminDao.findAll();
    }

    public Admin getAdminByEmail(String email) { return adminDao.findByEmail(email);}


    public Admin getActualAdmin(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            Admin actualAdmin = (Admin) session.getAttribute("admin");
            Boolean status = (Boolean) session.getAttribute("status");

            if (actualAdmin != null && status != null) {
                actualAdmin.setStatus(status);
            }

            return actualAdmin;
        }
        return null;
    }
}
