package com.rd.model;


import java.sql.Timestamp;

public class Transaction {
    private int id;
    private int walletId;
    private String type; // "income" or "expense"
    private double amount;
    private Timestamp timestamp;

    public Transaction(int id, int walletId, String type, double amount, Timestamp timestamp) {
        this.id = id;
        this.walletId = walletId;
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    // Getters
    public int getId() { return id; }
    public int getWalletId() { return walletId; }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public Timestamp getTimestamp() { return timestamp; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setWalletId(int walletId) { this.walletId = walletId; }
    public void setType(String type) { this.type = type; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setTimestamp(Timestamp timestamp) { this.timestamp = timestamp; }

    @Override
    public String toString() {
        return "Transaction{id=" + id +
                ", walletId=" + walletId +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", timestamp=" + timestamp + '}';
    }
}


