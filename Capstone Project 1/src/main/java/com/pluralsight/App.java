package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static Scanner keyboard = new Scanner(System.in);

    public static ArrayList<Product> cart = new ArrayList<Product>();

    public static HashMap<String, Product> transaction = new HashMap<String, Product>();

    public static void main(String[] args) {

        transaction = getTransaction();

        System.out.println("Welcome to Financial Tracker");
        System.out.println("");


        while(true) {
            System.out.println("What do you want to do?");
            System.out.println("\t1- Add Deposit\n" +
                    "\t2- Make Payment\n" +
                    "\t3- Ledger\n" +
                    "\t4- Exit\n");
            System.out.print("Enter Selection: ");
            int selection = keyboard.nextInt();
            keyboard.nextLine(); //consume CRLF

            switch (selection) {
                case 1:
                    displayProductMenu();
                    break;
                case 2:
                    displayCartMenu();
                    break;
                case 3:


                    System.exit(4);
                default:
                    System.out.println("Invalid selection, please choose again");
            }
        }
    }

    public static HashMap<String, Product> getTransaction() {
        HashMap<String, Product> products = new HashMap<String, Product>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/transaction.csv"));
            String line;
            br.readLine(); //skips first line

            while((line = br.readLine()) != null) {
                //line == AV1051|JBL Bluetooth Speaker|89.95|Audio Video
                String[] splitItems = line.split(Pattern.quote("|"));

                products.put(splitItems[0], new Product(splitItems[0], splitItems[1], splitItems[3], Double.parseDouble(splitItems[2])));
            }

        } catch(IOException e) {
            e.printStackTrace();
        }

        return products;
    }

    public static void displayProductMenu() {
        boolean run = true;

        while(run) {

            System.out.println("\t1- Display All Products\n" +
                    "\t2- Add Product to Cart\n" +
                    "\t3- Go Back\n");
            System.out.print("Enter Selection: ");
            int selection = keyboard.nextInt();
            keyboard.nextLine(); //consume CRLF

            switch (selection) {
                case 1:
                    viewAllProducts();
                    break;
                case 2:
                    addProductToCartMenu();
                    break;
                case 3:
                default:
                    run = false;
                    break;
            }
        }
    }

    public static void displayCartMenu() {
        boolean run = true;

        while(run) {
            System.out.println("\t1- View All Cart\n" +
                    "\t2- Remove Item From Cart\n" +
                    "\t3- Go Back\n");
            System.out.print("Enter Selection: ");
            int selection = keyboard.nextInt();
            keyboard.nextLine(); //consume CRLF

            switch (selection) {
                case 1:
                    viewAllCart();
                    break;
                case 2:
                    removeItemFromCart();
                    break;
                case 3:
                default:
                    run = false;
                    break;
            }
        }
    }

    public static void addProductToCartMenu() {
        System.out.print("Please enter the SKU of the product you want in your cart: ");
        String sku = keyboard.nextLine();

        Product product = searchSKU(sku);

        cart.add(product);
    }

    public static void removeItemFromCart() {
        System.out.print("Please enter the SKU of the product you want remove from your cart: ");
        String sku = keyboard.nextLine();

        for (int i = 0; i < cart.size(); i++) {

            if (cart.get(i).getSku().equalsIgnoreCase(sku)){
                cart.remove(i);
            }
        }
    }

    public static void viewAllCart() {
        for(Product product : cart) {
            System.out.println(product);
        }
    }

    public static void viewAllProducts() {
        for(Product product : transaction.values()) {
            System.out.println(product);
        }
    }

    public static Product searchSKU(String searchSKU) {
        Product product = new Product("", "", "", 0.0);
        for(String sku : transaction.keySet()) {
            if (searchSKU.trim().equalsIgnoreCase(sku)){
                product = transaction.get(sku);
            }
        }
        return product;
    }
}



