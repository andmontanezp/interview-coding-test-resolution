package com.anderson.testco;

import com.anderson.testco.entities.Product;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Product("Medium Coverage", 10, 20),
                new Product("Full Coverage", 2, 0),
                new Product("Low Coverage", 5, 7),
                new Product("Mega Coverage", 0, 80),
                new Product("Mega Coverage", -1, 80),
                new Product("Special Full Coverage", 15, 20),
                new Product("Special Full Coverage", 10, 49),
                new Product("Special Full Coverage", 5, 49),
                new Product("Super Sale", 3, 6)
        };

        System.out.println(String.format("-------- day %d --------", 0));
        new Printer(new CarInsurance(products).getProducts()).print();
        System.out.println("name, sellIn, price");
        System.out.println();

        for (int i = 1; i <= 30; i++) {
            System.out.println(String.format("-------- day %d --------", i));
            System.out.println("name, sellIn, price");
            new Printer(new CarInsurance(products).updatePrice()).print();
            System.out.println();
        }
    }
}
