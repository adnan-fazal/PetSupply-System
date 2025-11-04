package com.pawshop;
import java.util.HashMap;
import java.util.ArrayList;

public class Authentication {
    private final HashMap<String, String> userRoles = new HashMap<>();
    private final HashMap<String, String> credentials = new HashMap<>();
    private final ArrayList<String> createdCashiers = new ArrayList<>(); // To store cashier accounts

    public Authentication() {
        // Default Manager Account
        credentials.put("admin", "admin123");
        userRoles.put("admin", "Manager");

        // Default Cashier Account
        credentials.put("cashier", "cashier123");
        userRoles.put("cashier", "Cashier");
    }

    // Method to validate login
    public boolean login(String username, String password) {
        return credentials.containsKey(username) && credentials.get(username).equals(password);
    }

    // Method to get the role of a user
    public String getRole(String username) {
        return userRoles.getOrDefault(username, "Unknown");
    }

    // Method to add a new account (used by Manager to create Cashier accounts)
    public void addAccount(String username, String password, String role) {
        credentials.put(username, password);
        userRoles.put(username, role);
        if ("Cashier".equals(role)) {
            createdCashiers.add(username); // Add created cashier to the list
        }
    }

    // Get the list of created cashier accounts
    public ArrayList<String> getCreatedCashiers() {
        return createdCashiers;
    }
}
