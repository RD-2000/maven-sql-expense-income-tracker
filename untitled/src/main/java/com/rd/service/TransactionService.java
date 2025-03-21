package com.rd.service;


import com.rd.model.Transaction;
import com.rd.repository.TransactionRepository;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class TransactionService {
    private final TransactionRepository transactionRepository = new TransactionRepository();

    public TransactionService() throws SQLException {
    }

    public boolean addIncome(int walletId, double amount) {
        return transactionRepository.addTransaction(new Transaction(0, walletId, "income", amount, new Timestamp(System.currentTimeMillis())));
    }

    public boolean addExpense(int walletId, double amount) {
        return transactionRepository.addTransaction(new Transaction(0, walletId, "expense", amount, new Timestamp(System.currentTimeMillis())));
    }

    public void viewTransactions(int walletId) {
        List<Transaction> transactions = transactionRepository.getTransactionsByWalletId(walletId);
        if (transactions.isEmpty()) {
            System.out.println("⚠ No transactions found!");
        } else {
            for (Transaction transaction : transactions) {
                System.out.println("📌 " + transaction.getType() + ": $" + transaction.getAmount() + " | " + transaction.getTimestamp());
            }
        }
    }
}
