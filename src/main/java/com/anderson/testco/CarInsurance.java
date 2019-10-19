package com.anderson.testco;

import com.anderson.testco.entities.Product;

public class CarInsurance {
    private Product[] products;

    public CarInsurance(Product[] products) {
        this.products = products;
    }

    public Product[] updatePrice() {
        for (Product product: this.products) {
            product.decreaseSellIn();
            product.decreasePrice();

            if (product.sellByDateHasPassed()) {
                product.decreasePrice();
            }
        }
        return products;
    }

    public Product[] getProducts() {
        return products;
    }
}
