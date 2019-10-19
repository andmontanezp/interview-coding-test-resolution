package com.anderson.testco;

import com.anderson.testco.entities.Product;

public class CarInsurance {
    private Product[] products;

    public CarInsurance(Product[] products) {
        this.products = products;
    }

    public Product[] updatePrice() {
        return products;
    }

    public Product[] getProducts() {
        return products;
    }
}
