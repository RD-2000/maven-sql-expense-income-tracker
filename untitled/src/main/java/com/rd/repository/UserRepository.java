package com.rd.repository;


import com.rd.model.User;

import java.sql.*;

public class UserRepository {
    private DatabaseMetaData DatabaseConnection;
    private final Connection connection = DatabaseConnection.getConnection();

    public UserRepository() throws SQLException {
    }

    public void registerUser(String username, String password) {
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            System.out.println("✅ User Registered Successfully!");
        } catch (SQLException e) {
            System.err.println(" User Registration Failed: " + e.getMessage());
        }
    }

    public boolean loginUser(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            return rs.next(); // Returns true if user exists
        } catch (SQLException e) {
            System.err.println(" Login Failed: " + e.getMessage());
        }
        return false;
    }

    public boolean getUserByUsername(String username) {
        return false;
    }

    public boolean addUser(User user) {
        return false;
    }
}
