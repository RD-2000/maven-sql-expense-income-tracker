package com.rd.repository;


import com.rd.model.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
    private DatabaseMetaData DatabaseConnection;
    private final Connection connection = DatabaseConnection.getConnection();

    public TransactionRepository() throws SQLException {
    }

    // Retrieve all transactions for a wallet
    public List<Transaction> getTransactions(int walletId) {
        List<Transaction> transactions = new ArrayList<>();
        String query = "SELECT * FROM transactions WHERE wallet_id = ? ORDER BY timestamp DESC";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, walletId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                transactions.add(new Transaction(
                        rs.getInt("id"),
                        rs.getInt("wallet_id"),
                        rs.getString("type"),
                        rs.getDouble("amount"),
                        rs.getTimestamp("timestamp")
                ));
            }
        } catch (SQLException e) {
            System.err.println(" Error Fetching Transactions: " + e.getMessage());
        }
        return transactions;
    }


    public List<Transaction> getTransactionsByWalletId(int walletId) {
        return List.of();
    }

    public boolean addTransaction(Transaction income) {
        return false;
    }
}
