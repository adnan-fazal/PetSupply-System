package com.pawshop;

import java.util.HashMap;

public class AdminHandler {
    private HashMap<String, String> users;

    // Modify the constructor to accept a HashMap argument
    public AdminHandler(HashMap<String, String> users) {
        this.users = users;
    }

    public void createCashierAccount(String username, String password) {
        users.put(username, password); // Add the new cashier account to the users list
    }

    public void changePassword(String username, String newPassword) {
        if (users.containsKey(username)) {
            users.put(username, newPassword); // Change password
        } else {
            System.out.println("User does not exist.");
        }
    }
}
