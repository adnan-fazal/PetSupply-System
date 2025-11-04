package com.pawshop;

import java.util.ArrayList;
import java.util.List;

public class TransactionHandler {
    private List<String> transactions; // Store transactions

    public TransactionHandler() {
        transactions = new ArrayList<>();
    }

    // Method to get all transactions (could be enhanced to return more detailed data)
    public List<String> getAllTransactions() {
        return transactions;
    }

    // Method to create a new transaction
    public void createTransaction(String petSupply, int quantity) {
        // Logic to add a transaction (e.g., store supply name and quantity)
        String transaction = "Supply: " + petSupply + ", Quantity: " + quantity;
        transactions.add(transaction); // Add the transaction to the list
    }
}
