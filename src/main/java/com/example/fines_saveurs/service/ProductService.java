package com.example.fines_saveurs.service;

import com.example.fines_saveurs.dao.CategoryDao;
import com.example.fines_saveurs.dao.ProductDao;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class ProductService {

    private final ProductDao productDao = new ProductDao();


    public void saveImage(InputStream stream) {
        new ProductDao().addImage(stream);
    }

    public List<InputStream> getImages() {
        return productDao.fetchImages();
    }
}
