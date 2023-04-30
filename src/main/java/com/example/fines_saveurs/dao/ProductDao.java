package com.example.fines_saveurs.dao;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private final Connection connection = DataBase.getConnection();


    public void addImage(InputStream stream) {
        String query = "INSERT INTO product (image) VALUES (?);";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setBlob(1, stream);
            pst.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        }
    }


    public List<InputStream> fetchImages() {
        List<InputStream> inputStreams = new ArrayList<>();
        String query = "SELECT id_product, image FROM product WHERE image IS NOT NULL ";
        try (Statement statement  = connection.createStatement()) {
            statement.setEscapeProcessing(false);
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                Blob blob = result.getBlob("image");
                InputStream stream = blob.getBinaryStream();
                inputStreams.add(stream);
            }
        } catch (SQLException | NullPointerException error) {
            error.printStackTrace();
        }
        return inputStreams;
    }

/*

    public List<InputStream> fetchImages() {
        List<InputStream> inputStreams = new ArrayList<>();
        String query = "SELECT * from product WHERE image IS NOT NULL ";
        try (Statement statement  = connection.createStatement()) {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                Blob blob = result.getBlob("image");
                byte[] bytes = blob.getBytes(1, (int) blob.length());
                try (FileOutputStream fos = new FileOutputStream("image.jpg")) {
                    fos.write(bytes, 0, (int) blob.length());
                } catch (IOException error) {
                    error.printStackTrace();
                }
            }
        } catch (SQLException | NullPointerException error) {
            error.printStackTrace();
        }
        return inputStreams;
    }
*/


}
