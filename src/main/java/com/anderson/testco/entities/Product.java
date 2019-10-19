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

    public boolean sellByDateHasPassed() {
        return this.sellIn < 0;
    }

    public void decreaseSellIn() {
        this.sellIn = this.sellIn - 1;
    }

    public void decreasePrice() {
        if ((this.price - 1) <= 0) {
            this.price = 0;
            return;
        }
        this.price = this.price - 1;
    }

    public void increasePrice() {
        if((this.price + 1) > 50) {
            this.price = 50;
            return;
        }
        this.price = this.price + 1;
    }

    public void invalidateProduct() {
        this.price = 0;
    }

    @Override
    public String toString() {
        return String.format("%s, %d, %d", this.getName(), this.getSellIn(), this.getPrice());
    }
}
