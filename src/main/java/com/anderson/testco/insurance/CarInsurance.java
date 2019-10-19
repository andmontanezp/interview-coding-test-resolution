package com.anderson.testco.insurance;

import com.anderson.testco.factory.CoverageFactory;
import com.anderson.testco.coverage.Coverage;
import com.anderson.testco.entities.Product;

import java.util.Arrays;

public class CarInsurance {
    private Product[] products;

    public CarInsurance(Product[] products) {
        this.products = products;
    }

    public Product[] updatePrice() {
        return Arrays.stream(this.products).map(product -> {
            Coverage coverage = CoverageFactory.fromCoverageName(product.getName());
            return coverage.apply(product);
        }).toArray(Product[]::new);
    }

    public Product[] getProducts() {
        return products;
    }
}
