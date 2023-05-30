package com.example.fines_saveurs.service;

import com.example.fines_saveurs.dao.AdminDao;
import com.example.fines_saveurs.dao.AdminJdbcDao;
import com.example.fines_saveurs.dao.ProductJdbcDao;
import com.example.fines_saveurs.model.Admin;
import com.example.fines_saveurs.model.Category;
import com.example.fines_saveurs.model.Product;
import com.example.fines_saveurs.model.Ticket;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public class AdminService {
    private final AdminDao adminDao;

    public AdminService() {
        adminDao = new AdminJdbcDao();
    }
    public AdminService(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public boolean login(String email, String password) {
        Admin adminFound = adminDao.findByEmail(email);
        if (adminFound != null) {
            return adminFound.getPassword().equals(password);
        }
        return false;
    }

    public Admin fetchAdminById(long id) {
        return adminDao.findById(id);
    }

    public boolean addAdmin(String email, String password, String firstname, String lastname) {
        Admin newAdmin = new Admin(email, password, firstname, lastname);
        return adminDao.create(newAdmin);
    }

    public List<Admin> fetchAllAdmins() {
        return adminDao.findAll();
    }

    public Admin getAdminByEmail(String email) { return adminDao.findByEmail(email);}

    public void updateAdmin(Admin admin) {
        adminDao.update(admin);
    }

    public boolean deleteAdmin(long id) {
        return adminDao.delete(new Admin(id));
    }

    public List<Admin> fetchEmptyAdmins() {
        return adminDao.fetchEmptyAdmins();
    }
}
