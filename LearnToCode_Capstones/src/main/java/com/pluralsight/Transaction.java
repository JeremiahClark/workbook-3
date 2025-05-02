package com.pluralsight;

 import java.time.LocalDate;
 import java.time.LocalTime;
 import java.time.chrono.ChronoLocalDate;

public class Transaction {

    public ChronoLocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;

    public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public Transaction(LocalDate parse, LocalDate parse1, String part, String part1, double amount) {
    }

    public String toCSV() {
        return date + "|" + time + "|" + description + "|" + vendor + "|" + amount;
    }

    @Override
    public String toString() {
        return String.format("%s %s %-20s %-15s %10.2f", date, time, description, vendor, amount);
    }
}



































