package com.pluralsight;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        store store = new Store();
        Cart cart = new Cart();
        store.loadProducts("products.csv");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\nStore Menu:");
            System.out.println("1. Display Products");
            System.out.println("2. Display Cart");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    store.displayProducts();
                    System.out.println("\nOptions: search | add [SKU] | back");
                    String action = scanner.nextLine().toLowerCase();
                    if (action.equals("search")) {
                        System.out.print("Enter search keyword: ");
                        String keyword = scanner.nextLine();
                        List<Product> results = store.search(keyword);
                        for (Product p : results) {
                            System.out.println(p);
                        }
                    } else if (action.startsWith("add")) {
                        String[] parts = action.split(" ");
                        if (parts.length == 2) {
                            Product product = store.findBySku(parts[1]);
                            if (product != null) {
                                cart.add(product);
                                System.out.println("Product added to cart.");
                            } else {
                                System.out.println("Product not found.");
                            }
                        }
                    }
                    break;
                case "2":
                    cart.display();
                    System.out.println("\nOptions: remove [SKU] | back");
                    String cartAction = scanner.nextLine().toLowerCase();
                    if (cartAction.startsWith("remove")) {
                        String[] parts = cartAction.split(" ");
                        if (parts.length == 2) {
                            cart.remove(parts[1]);
                        }
                    }
                    break;
                case "3":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        System.out.println("Thank you for shopping!");
    }
}

























}























