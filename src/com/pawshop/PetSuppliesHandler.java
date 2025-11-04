package com.pawshop;

import java.util.ArrayList;
import java.util.List;

public class PetSuppliesHandler {
    private List<String> supplies = new ArrayList<>();

    // Constructor to initialize some supplies
    public PetSuppliesHandler() {
        supplies.add("Pet Food");
        supplies.add("Pet Toy");
        supplies.add("Leash");
        supplies.add("Collar");
        supplies.add("Shampoo");
        supplies.add("Grooming Kit");
        supplies.add("Pet Bed");
        supplies.add("Cat Litter");
        supplies.add("Dog Leash");
        supplies.add("Bird Cage");
        supplies.add("Bird Food");
        supplies.add("Fish Tank");
        supplies.add("Fish Food");
        supplies.add("Pet Carrier");
        supplies.add("Chew Toys");
        supplies.add("Treats");
        supplies.add("Pet Clothing");
        supplies.add("Harness");
        supplies.add("Pet Bowl");
        supplies.add("Pet Brush");
    }

    // Get all supplies
    public List<String> getSupplies() {
        return supplies;
    }
}

