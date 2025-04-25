package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InventoryService {
    private List<Product> Products = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();

        System.out.println("Store Product:");
        for (Product product : inventory) {
            System.out.println(product);
        }
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();

        // BONUS: Load from inventory.csv
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/CSV"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());

                    inventory.add(new Product(id, name, price));
                        System.out.println("What do you want to do?");
                        System.out.println("\t1- List all products\n" +
                                "\t2- Lookup a product by its id\n" +
                                "\t3- Find all products within a price range\n" +
                                "\t4- Add a new product\n" +
                                "\t5- Quit the application\n");
                        System.out.print("Enter Selection: ");


                    }
                }
            } catch(IOException e){
                System.out.println("Could not read from file. Loading default products...");


            }


            return inventory;
        }
    }


































