package com.example.fines_saveurs.resources;

import com.example.fines_saveurs.dao.AdminDao;
import com.example.fines_saveurs.dao.AdminJdbcDao;
import com.example.fines_saveurs.model.Admin;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/admins")
public class AdminResource {
    private AdminDao adminDao = new AdminJdbcDao();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Admin> getAllAdmins() {
        System.out.println("adminDao.findAll()");
        return adminDao.findAll();
    }
}
