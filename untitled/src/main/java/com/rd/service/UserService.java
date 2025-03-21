package com.rd.service;


import com.rd.model.User;
import com.rd.repository.UserRepository;

import java.sql.SQLException;

public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public UserService() throws SQLException {
    }

    public boolean registerUser(String username, String password) {
        if (userRepository.getUserByUsername(username) != null) {
            System.out.println(" Username already exists!");
            return false;
        }
        return userRepository.addUser(new User(0, username, password));
    }

    public User loginUser(String username, String password) {
        User user = userRepository.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful!");
            return user;
        }
        System.out.println(" Invalid username or password.");
        return null;
    }
}

