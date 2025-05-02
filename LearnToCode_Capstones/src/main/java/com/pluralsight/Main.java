package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            displayHomeScreen();
            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "A":
                    addDeposit();
                    break;
                case "B":
                    makePayment();
                    break;
                case "C":
                    viewLedger();
                    break;
                case "D":
                    running = false;
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void displayHomeScreen() {
        System.out.println("\n==== Financial Tracker ====");
        System.out.println("A) Add Deposit");
        System.out.println("B) Make Payment (Debit)");
        System.out.println("C) Ledger");
        System.out.println("D) Exit");
        System.out.print("Choose an option: ");
    }

    private static void addDeposit() {
        System.out.println("\n=== Add Deposit ===");
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter vendor: ");
        String vendor = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        Transaction deposit = new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, amount);
        TransactionRepository.saveTransaction(deposit);
        System.out.println("Deposit saved successfully.");
    }

    private static void makePayment() {
        System.out.println("\n=== Make Payment ===");
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter vendor: ");
        String vendor = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        Transaction payment = new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, -Math.abs(amount));
        TransactionRepository.saveTransaction(payment);
        System.out.println("Payment saved successfully.");
    }

    private static void viewLedger() {
        System.out.println("\n=== Ledger ===");
        List<Transaction> transactions = TransactionRepository.loadTransactions();
        transactions.sort((t1, t2) -> t2.date.compareTo(t1.date)); // Newest first
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}