package com.rd.controller;

import com.rd.service.TransactionService;

import java.sql.SQLException;
import java.util.Scanner;

public class MainController {
    private final TransactionService transactionService = new TransactionService();
    private final Scanner scanner = new Scanner(System.in);

    public MainController() throws SQLException {
    }

    private void addTransaction() {
        System.out.print("Enter wallet ID: ");
        int walletId = scanner.nextInt();
        System.out.print("Enter transaction type (income/expense): ");
        String type = scanner.next();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        if (type.equalsIgnoreCase("income")) {
            transactionService.addIncome(walletId, amount);
        } else if (type.equalsIgnoreCase("expense")) {
            transactionService.addExpense(walletId, amount);
        } else {
            System.out.println(" Invalid transaction type.");
        }
    }

    private void viewTransactions() {
        System.out.print("Enter wallet ID: ");
        int walletId = scanner.nextInt();
        transactionService.viewTransactions(walletId);
    }
}
