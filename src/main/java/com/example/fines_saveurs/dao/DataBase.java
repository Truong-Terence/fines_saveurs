package com.example.fines_saveurs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DataBase {
    private static Connection INSTANCE;
//    TODO https://www.editions-eni.fr/open/mediabook.aspx?idR=88521626f29b9f7b8a4481050727b07e
//    TODO retirer credentials de github
    private static final String url = "jdbc:mysql://localhost:3306/flavour";
    private static final String user = "";
    private static final String password = "";

    private DataBase() {
    }

    public static Connection getConnection() {
        if (INSTANCE == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                INSTANCE = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.err.println("Error during getConnection");
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                System.err.println("Error during loading driver");
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return INSTANCE;
    }


}
