package com.rd.repository;

import com.rd.databaseconnection.DatabaseConnection;
import com.rd.model.Wallet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WalletRepository {
    private final Connection connection;

    public WalletRepository() {
        this.connection = DatabaseConnection.getConnection();
    }

    // Add a new wallet
    public boolean addWallet(Wallet wallet) {
        String sql = "INSERT INTO wallets (user_id, name, balance) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, wallet.getUserId());
            statement.setString(2, wallet.getName());
            statement.setDouble(3, wallet.getBalance());

            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error adding wallet: " + e.getMessage());
            return false;
        }
    }

    // Get all wallets for a user
    public List<Wallet> getWalletsByUserId(int userId) {
        List<Wallet> wallets = new ArrayList<>();
        String sql = "SELECT * FROM wallets WHERE user_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                wallets.add(new Wallet(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("balance")
                ));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error retrieving wallets: " + e.getMessage());
        }
        return wallets;
    }

    // Get a wallet by ID
    public Wallet getWalletById(int walletId) {
        String sql = "SELECT * FROM wallets WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, walletId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Wallet(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("balance")
                );
            }
        } catch (SQLException e) {
            System.out.println("❌ Error fetching wallet: " + e.getMessage());
        }
        return null;
    }

    // Update wallet balance
    public boolean updateWalletBalance(int walletId, double newBalance) {
        String sql = "UPDATE wallets SET balance = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, newBalance);
            statement.setInt(2, walletId);

            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error updating balance: " + e.getMessage());
            return false;
        }
    }

    // Delete a wallet by ID
    public boolean deleteWallet(int walletId) {
        String sql = "DELETE FROM wallets WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, walletId);
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting wallet: " + e.getMessage());
            return false;
        }
    }
}
