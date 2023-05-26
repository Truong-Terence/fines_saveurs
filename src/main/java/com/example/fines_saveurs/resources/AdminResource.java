package com.example.fines_saveurs.resources;

import com.example.fines_saveurs.dao.AdminDao;
import com.example.fines_saveurs.dao.AdminJdbcDao;
import com.example.fines_saveurs.model.Admin;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/admins")
public class AdminResource {
    private AdminDao adminDao = new AdminJdbcDao();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAdmins() {
        List<Admin> adminList = adminDao.findAll();
        return Response
                .ok(adminList)
                .build();
    }
}
