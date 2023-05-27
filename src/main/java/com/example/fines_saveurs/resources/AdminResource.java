package com.example.fines_saveurs.resources;

import com.example.fines_saveurs.dao.AdminDao;
import com.example.fines_saveurs.dao.AdminJdbcDao;
import com.example.fines_saveurs.dto.AdminDTO;
import com.example.fines_saveurs.model.Admin;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/admins")
public class AdminResource {
    private AdminDao adminDao = new AdminJdbcDao();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAdmins() {
        List<Admin> adminList = adminDao.findAll();

        List<AdminDTO> adminDTOList = new ArrayList<>();
        for (Admin admin : adminList) {
            AdminDTO adminDTO = new AdminDTO();
            adminDTO.setId(admin.getId());
            adminDTO.setFirstname(admin.getFirstname());
            adminDTO.setLastname(admin.getLastname());
            adminDTOList.add(adminDTO);
        }
        return Response
                .ok(adminDTOList)
                .build();
    }
}
