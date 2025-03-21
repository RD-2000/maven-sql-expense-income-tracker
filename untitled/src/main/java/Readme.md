# 💰 Expense Income  Tracker (Java 21, Maven)

## 📖 Overview

Expense Tracker is a **console-based application** that helps users manage their **income, expenses, and wallets**. The project follows an **MVC architecture** with **JDBC connectivity** to MySQL Workbench.

## Technologies Used

- Java 21 (Latest features)
- Maven (Dependency management)
- MySQL Workbench(Database management)
- JDBC (Database connectivity)
- JUnit(Testing)

## Version

- Current Version: 1.0.0
- Java Version: 21
- Maven Version: Latest Stable Release
- MySQL Version: 8.0+

 Project Structure


##  Features

- ✅ **User Management**: Register & Login
- ✅ **Wallet Management**: Create, View & Delete Wallets
- ✅ **Transaction Management**: Add Income & Expenses
- ✅ **View Transactions**: Separate views for income & expenses
- ✅ **Persistent Storage**: Stores data in **MySQL**

##  Prerequisites

Before running the project, install:

- **Java 21**
- **Maven**
- **MySQL Workbench**

##  Database Setup (MySQL Workbench)

### **1️⃣ Create Database**
```sql
CREATE DATABASE stepupdb;
USE stepupdb;
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);
CREATE TABLE wallets (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    balance DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
CREATE TABLE transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    wallet_id INT NOT NULL,
    type ENUM('income', 'expense') NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (wallet_id) REFERENCES wallets(id) ON DELETE CASCADE
);

##  Getting Started

1️⃣ Clone the Repository
git clone https://github.com/your-repo/expense-tracker.git
cd expense-tracker
2️⃣ Configure Database Connection
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/stepupdb";
    private static final String USER = "root";
    private static final String PASSWORD = "yourpassword";
}
3️⃣ Build the Project
4️⃣ Run the Application

 Future Improvements
🔹 Add a GUI-based interface
🔹 Implement REST APIs
🔹 Improve authentication (hashing passwords)

##  Contributing
Fork the repository.
Create a new branch (feature-new-feature).
Commit your changes.
Push the branch and create a pull request.