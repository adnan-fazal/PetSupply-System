package com.pawshop;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PawPetShopPortal {
    private Authentication authentication = new Authentication();
    private List<String> transactions = new ArrayList<>(); // List to hold transactions (purchased supplies)

    // Show Login Interface
    public void showLogin() {
        JFrame loginFrame = new JFrame("PawPetShop - Login");
        loginFrame.setSize(400, 400); // Increased height to accommodate the icon
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Login Panel with Background Image
        JPanel loginPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("resources/images/login_bg.jpg"); // Background image
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        loginPanel.setLayout(null);

        // Add Login Icon
        ImageIcon loginIcon = new ImageIcon("resources/images/login_icon.png"); // Load the login icon
        JLabel iconLabel = new JLabel(loginIcon); // Create a JLabel with the icon
        iconLabel.setBounds(150, 10, 100, 100); // Set the position and size of the icon
        loginPanel.add(iconLabel);

        // Username and Password Fields
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 130, 80, 25);
        userLabel.setForeground(Color.BLACK); // Text color changed to black
        loginPanel.add(userLabel);

        JTextField userText = new JTextField();
        userText.setBounds(150, 130, 165, 25);
        loginPanel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 180, 80, 25);
        passwordLabel.setForeground(Color.BLACK); // Text color changed to black
        loginPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 180, 165, 25);
        loginPanel.add(passwordField);

        // Show Password Checkbox
        JCheckBox showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.setBounds(150, 210, 150, 25);
        showPasswordCheckBox.setForeground(Color.BLACK); // Text color changed to black
        showPasswordCheckBox.addActionListener(e -> {
            if (showPasswordCheckBox.isSelected()) {
                passwordField.setEchoChar((char) 0); // Show password
            } else {
                passwordField.setEchoChar('*'); // Hide password
            }
        });
        loginPanel.add(showPasswordCheckBox);

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 250, 100, 30);
        loginButton.addActionListener(e -> {
            String username = userText.getText();
            String password = new String(passwordField.getPassword());
            if (authentication.login(username, password)) {
                String role = authentication.getRole(username);

                // Show success message
                JOptionPane.showMessageDialog(loginFrame, "Successfully logged in as " + role);

                // Navigate to the appropriate dashboard
                if ("Manager".equals(role)) {
                    showManagerDashboard();
                } else {
                    showCashierDashboard();
                }
                loginFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(loginFrame, "Invalid credentials");
            }
        });
        loginPanel.add(loginButton);

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setBounds(150, 300, 100, 30);
        backButton.addActionListener(e -> {
            userText.setText("");
            passwordField.setText("");
        });
        loginPanel.add(backButton);

        loginFrame.add(loginPanel);
        loginFrame.setVisible(true);
    }


    // Manager Dashboard
    public void showManagerDashboard() {
        JFrame managerFrame = new JFrame("Manager Dashboard");
        managerFrame.setSize(600, 400);
        managerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Manager Panel with Background Image
        JPanel managerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("resources/images/manager_bg.webp"); // Background image
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        managerPanel.setLayout(null);

        JLabel loggedInLabel = new JLabel("Logged in as: Manager");
        loggedInLabel.setBounds(10, 10, 200, 25);
        loggedInLabel.setForeground(Color.BLACK);
        managerPanel.add(loggedInLabel);

        JButton viewSuppliesButton = new JButton("View Supplies");
        viewSuppliesButton.setBounds(50, 100, 200, 40);
        viewSuppliesButton.addActionListener(e -> showViewSupplies());  // Show Supplies
        managerPanel.add(viewSuppliesButton);

        JButton viewTransactionsButton = new JButton("View Transactions");
        viewTransactionsButton.setBounds(300, 100, 200, 40);
        viewTransactionsButton.addActionListener(e -> showViewTransactions());  // Show Transactions
        managerPanel.add(viewTransactionsButton);

        JButton createCashierButton = new JButton("Create Cashier Account");
        createCashierButton.setBounds(50, 200, 200, 40);
        createCashierButton.addActionListener(e -> showCreateCashierAccount());
        managerPanel.add(createCashierButton);

        JButton viewCreatedAccountsButton = new JButton("View Created Accounts");
        viewCreatedAccountsButton.setBounds(300, 200, 200, 40);
        viewCreatedAccountsButton.addActionListener(e -> showViewCreatedAccounts());
        managerPanel.add(viewCreatedAccountsButton);

        JButton logOutButton = new JButton("Log Out");
        logOutButton.setBounds(300, 250, 200, 40);
        logOutButton.addActionListener(e -> {
            managerFrame.dispose();
            showLogin();
        });
        managerPanel.add(logOutButton);

        managerFrame.add(managerPanel);
        managerFrame.setVisible(true);
    }

    // Cashier Dashboard
    public void showCashierDashboard() {
        JFrame cashierFrame = new JFrame("Cashier Dashboard");
        cashierFrame.setSize(600, 400);
        cashierFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Cashier Panel with Background Image
        JPanel cashierPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("resources/images/cashier_bg.jpg"); // Background image
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        cashierPanel.setLayout(null);

        JLabel loggedInLabel = new JLabel("Logged in as: Cashier");
        loggedInLabel.setBounds(10, 10, 200, 25);
        loggedInLabel.setForeground(Color.BLACK);
        cashierPanel.add(loggedInLabel);

        JButton viewInventoryButton = new JButton("View Inventory");
        viewInventoryButton.setBounds(50, 100, 200, 40);
        viewInventoryButton.addActionListener(e -> JOptionPane.showMessageDialog(cashierFrame, "Inventory Viewed!"));
        cashierPanel.add(viewInventoryButton);

        JButton createTransactionButton = new JButton("Create Transaction");
        createTransactionButton.setBounds(300, 100, 200, 40);
        createTransactionButton.addActionListener(e -> JOptionPane.showMessageDialog(cashierFrame, "Transaction created!"));
        cashierPanel.add(createTransactionButton);

        JButton logOutButton = new JButton("Log Out");
        logOutButton.setBounds(300, 200, 200, 40);
        logOutButton.addActionListener(e -> {
            cashierFrame.dispose();
            showLogin();
        });
        cashierPanel.add(logOutButton);

        cashierFrame.add(cashierPanel);
        cashierFrame.setVisible(true);
    }

    // Create Cashier Account Interface
    public void showCreateCashierAccount() {
        JFrame createAccountFrame = new JFrame("Create Cashier Account");
        createAccountFrame.setSize(400, 250);
        createAccountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel with Background Image
        JPanel createAccountPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("resources/images/acc_bg.jpg");
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        createAccountPanel.setLayout(null); // Use absolute positioning for custom layout

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 50, 80, 25);
        userLabel.setForeground(Color.BLACK); // Text color
        createAccountPanel.add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(150, 50, 200, 25);
        createAccountPanel.add(userField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 100, 80, 25);
        passLabel.setForeground(Color.BLACK); // Text color
        createAccountPanel.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 100, 200, 25);
        createAccountPanel.add(passField);

        // Show Password Checkbox
        JCheckBox showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.setBounds(150, 130, 150, 25);
        showPasswordCheckBox.setForeground(Color.BLACK); // Text color
        showPasswordCheckBox.addActionListener(e -> {
            if (showPasswordCheckBox.isSelected()) {
                passField.setEchoChar((char) 0); // Show password
            } else {
                passField.setEchoChar('*'); // Hide password
            }
        });
        createAccountPanel.add(showPasswordCheckBox);

        // Create Button
        JButton createButton = new JButton("Create");
        createButton.setBounds(250, 170, 100, 30);
        createButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());
            if (!username.isEmpty() && !password.isEmpty()) {
                authentication.addAccount(username, password, "Cashier");
                JOptionPane.showMessageDialog(createAccountFrame, "Cashier Account Created: " + username);
                createAccountFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(createAccountFrame, "Please fill in both fields.");
            }
        });
        createAccountPanel.add(createButton);

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setBounds(150, 210, 100, 30);
        backButton.addActionListener(e -> createAccountFrame.dispose());
        createAccountPanel.add(backButton);

        createAccountFrame.add(createAccountPanel);
        createAccountFrame.setVisible(true);
    }


    // Show View Created Accounts Interface
    public void showViewCreatedAccounts() {
        JFrame viewAccountsFrame = new JFrame("View Created Accounts");
        viewAccountsFrame.setSize(600, 400);
        viewAccountsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // View Accounts Panel with Background Image
        JPanel viewAccountsPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("resources/images/viewAcc_bg.jpg"); // Background image
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        viewAccountsPanel.setLayout(null);

        JLabel titleLabel = new JLabel("Created Cashier Accounts");
        titleLabel.setBounds(50, 20, 300, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(Color.BLACK);  // Black text color
        viewAccountsPanel.add(titleLabel);

        // Get the list of created cashier accounts from the authentication class
        DefaultListModel<String> accountListModel = new DefaultListModel<>();
        for (String account : authentication.getCreatedCashiers()) {
            accountListModel.addElement(account);
        }

        // Create a JList to display the cashier accounts
        JList<String> accountList = new JList<>(accountListModel);
        JScrollPane scrollPane = new JScrollPane(accountList);
        scrollPane.setBounds(50, 60, 500, 200); // Adjust bounds for scrollable list
        viewAccountsPanel.add(scrollPane);

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setBounds(250, 300, 100, 30);
        backButton.addActionListener(e -> viewAccountsFrame.dispose());
        viewAccountsPanel.add(backButton);

        viewAccountsFrame.add(viewAccountsPanel);
        viewAccountsFrame.setVisible(true);
    }


    // Show View Supplies Interface w
    public void showViewSupplies() {
        JFrame viewSuppliesFrame = new JFrame("View Supplies");
        viewSuppliesFrame.setSize(600, 400);
        viewSuppliesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel with Background Image
        JPanel viewSuppliesPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("resources/images/supp_bg.jpg"); // Use your supp_bg image here
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        viewSuppliesPanel.setLayout(null); // Use absolute positioning for custom layout

        JLabel titleLabel = new JLabel("List of Pet Supplies");
        titleLabel.setBounds(50, 20, 300, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(Color.BLACK);  // Black text color
        viewSuppliesPanel.add(titleLabel);

        // Supplies List (More than 10 supplies)
        String[] suppliesList = {
                "Pet Food", "Pet Toy", "Leash", "Collar", "Shampoo", "Grooming Kit",
                "Pet Bed", "Cat Litter", "Dog Leash", "Bird Cage", "Bird Food", "Fish Tank",
                "Fish Food", "Pet Carrier", "Chew Toys", "Treats", "Pet Clothing", "Harness",
                "Pet Bowl", "Pet Brush"
        };

        // Add checkboxes for each supply
        JCheckBox[] supplyCheckboxes = new JCheckBox[suppliesList.length];
        for (int i = 0; i < suppliesList.length; i++) {
            supplyCheckboxes[i] = new JCheckBox(suppliesList[i]);
            supplyCheckboxes[i].setBounds(50, 60 + (i * 30), 200, 25);
            viewSuppliesPanel.add(supplyCheckboxes[i]);
        }

        // Buy Button (Placed above the Back button)
        JButton buyButton = new JButton("Buy");
        buyButton.setBounds(250, 300, 100, 30);  // Adjusted position of Buy button
        buyButton.addActionListener(e -> {
            // Collect selected supplies
            StringBuilder selectedSupplies = new StringBuilder();
            for (int i = 0; i < supplyCheckboxes.length; i++) {
                if (supplyCheckboxes[i].isSelected()) {
                    selectedSupplies.append(suppliesList[i]).append("\n");
                }
            }

            if (selectedSupplies.length() > 0) {
                // Add selected items to the transactions list
                JOptionPane.showMessageDialog(viewSuppliesFrame, "You have bought:\n" + selectedSupplies.toString());
                addTransaction(selectedSupplies.toString());
            } else {
                JOptionPane.showMessageDialog(viewSuppliesFrame, "No items selected!");
            }
        });
        viewSuppliesPanel.add(buyButton);

        // Back Button (Placed below the Buy button)
        JButton backButton = new JButton("Back");
        backButton.setBounds(250, 340, 100, 30); // Positioned below the Buy button
        backButton.addActionListener(e -> {
            viewSuppliesFrame.dispose();
            showManagerDashboard(); // Go back to Manager Dashboard
        });
        viewSuppliesPanel.add(backButton);

        viewSuppliesFrame.add(viewSuppliesPanel);
        viewSuppliesFrame.setVisible(true);
    }


    // Method to add transaction to the list
    private void addTransaction(String selectedSupplies) {
        transactions.add(selectedSupplies);  // Store the selected items in the transactions list
    }

    // Show View Transactions Interface
    public void showViewTransactions() {
        JFrame viewTransactionsFrame = new JFrame("View Transactions");
        viewTransactionsFrame.setSize(600, 400);
        viewTransactionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // View Transactions Panel with Background Image
        JPanel viewTransactionsPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("resources/images/view_bg.jpg"); // Background image for view transactions
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        viewTransactionsPanel.setLayout(null);

        JLabel titleLabel = new JLabel("Transaction History");
        titleLabel.setBounds(50, 20, 300, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(Color.BLACK);  // Black text color
        viewTransactionsPanel.add(titleLabel);

        // Display all transactions (purchased items)
        StringBuilder transactionHistory = new StringBuilder();
        for (String transaction : transactions) {
            transactionHistory.append(transaction).append("\n");
        }

        JTextArea transactionsArea = new JTextArea(transactionHistory.toString());
        transactionsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(transactionsArea);
        scrollPane.setBounds(50, 60, 500, 200); // Adjust bounds for scrollable list
        viewTransactionsPanel.add(scrollPane);

        // Back Button (Go back to Manager Dashboard)
        JButton backButton = new JButton("Back");
        backButton.setBounds(250, 300, 100, 30);
        backButton.addActionListener(e -> {
            viewTransactionsFrame.dispose();
            showManagerDashboard(); // Go back to Manager Dashboard
        });
        viewTransactionsPanel.add(backButton);

        viewTransactionsFrame.add(viewTransactionsPanel);
        viewTransactionsFrame.setVisible(true);
    }


    // Main Method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PawPetShopPortal portal = new PawPetShopPortal();
            portal.showLogin(); // Call the public showLogin() method
        });
    }
}
