package com.anderson.testco.coverage;

import com.anderson.testco.entities.Product;

public class FullCoverage implements Coverage {

    @Override
    public Product apply(Product product) {
        product.decreaseSellIn();
        product.increasePrice();
        if (product.sellByDateHasPassed()) {
            product.increasePrice();
        }
        return product;
    }
}
