package com.example.fines_saveurs.resources;

import com.example.fines_saveurs.dao.CategoryJdbcDao;
import com.example.fines_saveurs.model.Category;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/categories")
public class CategoryResource {

    private CategoryJdbcDao categoryDao = new CategoryJdbcDao();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNotEmptyCategories() {
        List<Category> categoriesList = categoryDao.fetchNotEmptyCategories();
        return Response.ok(categoriesList).build();
    }
}
