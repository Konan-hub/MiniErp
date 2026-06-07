package com.core.erp.model;

public class Article {
    private String id;
    private String name;
    private String color;
    private String size;
    private double price;

    public Article(String rawData) {
        // Just in case the input string is completely empty or null
        if (rawData == null) {
            this.id = "ERR-404";
            this.name = "INVALID";
            this.color = "UNKNOWN";
            this.size = "UNKNOWN";
            this.price = 0.0;
            return;
        }

        String[] parts = rawData.split(";");

        // Check if we actually got all 5 fields to avoid index out of bounds crashes
        if (parts.length == 5) {
            this.id = parts[0];
            this.name = parts[1];
            this.color = parts[2];
            this.size = parts[3];
            this.price = Double.parseDouble(parts[4]);
        } else {
            // Fallback values if the CSV line is messed up or missing semicolons
            this.id = "ERR-404";
            this.name = "INVALID";
            this.color = "UNKNOWN";
            this.size = "UNKNOWN";
            this.price = 0.0;
        }
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getColor() { return color; }
    public String getSize() { return size; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price + "€" +
                '}';
    }
}