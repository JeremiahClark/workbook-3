package com.pluralsight;

public class Product {
    private String sku, name, department;
    private double price;

    public Product(String sku, String name, String department, double price) {
        this.sku = sku;
        this.name = name;
        this.department = department;
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", price=" + price +
                '}';
    }
}