package com.pluralsight;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;
public class TransactionRepository {

    private static final String FILE_PATH = "transactions.csv";

    public static void saveTransaction(Transaction transaction) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(transaction.toCSV());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static List<Transaction> loadTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
            for (String line : lines) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    Transaction t = new Transaction(
                            LocalDate.parse(parts[0]),
                            LocalDate.parse(parts[1]),
                            parts[2],
                            parts[3],
                            Double.parseDouble(parts[4])
                    );
                    transactions.add(t);
                }
            }
        } catch (IOException e) {
            System.out.println("src/main/resources/transactions.csv.");
        }
        return transactions;
    }
}

















