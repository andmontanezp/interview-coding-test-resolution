package com.anderson.testco.coverage;

import com.anderson.testco.entities.Product;

public class CommonCoverage implements Coverage {
    @Override
    public Product apply(Product product) {
        product.decreaseSellIn();
        product.decreasePrice();
        if (product.sellByDateHasPassed()) {
            product.decreasePrice();
        }
        return product;
    }
}
