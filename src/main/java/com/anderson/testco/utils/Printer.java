package com.anderson.testco.utils;

import com.anderson.testco.entities.Product;

public class Printer {

    private Product[] products;

    public Printer(Product[] products) {
        this.products = products;
    }

    public void print() {
        for (Product product: products) {
            System.out.println(product);
        }
    }
}
