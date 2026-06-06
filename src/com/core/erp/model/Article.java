package com.core.erp.model;

public class Article {
    private String id;
    private String name;
    private String color;
    private String size;
    private double price;

    public Article(String rawData) {
        String[] parts = rawData.split(";");
        this.id = parts[0];
        this.name = parts[1];
        this.color = parts[2];
        this.size = parts[3];
        this.price = Double.parseDouble(parts[4]);
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
