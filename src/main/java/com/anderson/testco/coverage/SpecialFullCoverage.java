package com.anderson.testco.coverage;

import com.anderson.testco.entities.Product;

public class SpecialFullCoverage implements Coverage {

    @Override
    public Product apply(Product product) {
        product.decreaseSellIn();

        if (product.getSellIn() < 0) {
            product.invalidateProduct();
            return product;
        }

        product.increasePrice();

        if (product.getSellIn() < 10 && product.getSellIn() >= 5) {
            product.increasePrice();
        } else if (product.getSellIn() < 5){
            product.increasePrice();
            product.increasePrice();
        }

        return product;
    }
}
