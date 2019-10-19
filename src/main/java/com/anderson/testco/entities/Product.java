package com.anderson.testco.entities;

public class Product {
    private String name;
    private int sellIn;
    private int price;

    public Product(String name, int sellIn, int price) {
        this.name = name;
        this.sellIn = sellIn;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s, %d, %d", this.getName(), this.getSellIn(), this.getPrice());
    }
}
