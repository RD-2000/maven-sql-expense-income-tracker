package com.rd.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/stepupdb";
    private static final String USER = "root";
    private static final String PASSWORD ="root";

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println(" Connected to Database Successfully!");
            } catch (SQLException e) {
                System.err.println(" Database Connection Failed: " + e.getMessage());
            }
        }
        return connection;
    }
}
