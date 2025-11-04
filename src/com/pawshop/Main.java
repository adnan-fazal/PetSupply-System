package com.pawshop;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PawPetShopPortal portal = new PawPetShopPortal();
            portal.showLogin();
        });
    }
}


