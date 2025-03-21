package com.rd.model;

public class Wallet {
    private int id;
    private int userId;
    private String name;
    private double balance;

    public Wallet(int id, int userId, String name, double balance) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.balance = balance;
    }

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public String getName() { return name; }
    public double getBalance() { return balance; }
}
