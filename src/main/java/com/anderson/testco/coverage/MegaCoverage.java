package com.anderson.testco.coverage;

import com.anderson.testco.entities.Product;

public class MegaCoverage implements Coverage {
    @Override
    public Product apply(Product product) {
        return product;
    }
}
