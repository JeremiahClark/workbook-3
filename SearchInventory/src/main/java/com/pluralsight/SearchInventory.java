package com.pluralsight;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class SearchInventory {


    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();

        System.out.println("Store Inventory:");
        for (Product product : inventory) {
            System.out.println(product);
        }
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();

        // BONUS: Load from inventory.csv
        try (BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());
                    inventory.add(new Product(id, name, price));
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read from file. Loading default products...");

            // Fallback hardcoded products
            inventory.add(new Product("1111", "10' 2x4  (grade B)", 9.99));
            inventory.add(new Product("2222", "Hammer", 19.49));
            inventory.add(new Product("3333", "Box of nails", 9.29));
            inventory.add(new Product("4444", "9-in-1 Ratcheting Screwdriver", 24.97));
            inventory.add(new Product("5555", "10\" Crescent Wrench", 15.95));
            inventory.add(new Product("6666", "Mechanics Tool Set", 119.00));
            inventory.add(new Product("7777", "2\" Spring Clamp", .99));
            inventory.add(new Product("8888", "Large Trigger Clamps", 36.97));

        }

        return inventory;
    }
}
