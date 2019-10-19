package com.anderson.testco.coverage;

import com.anderson.testco.entities.Product;

public class SuperSaleCoverage implements Coverage {
    @Override
    public Product apply(Product product) {
        product.decreaseSellIn();

        product.decreasePrice();
        product.decreasePrice();

        if (product.sellByDateHasPassed()) {
            product.decreasePrice();
            product.decreasePrice();
        }
        return product;
    }
}
