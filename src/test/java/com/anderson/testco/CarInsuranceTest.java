package com.anderson.testco;

import com.anderson.testco.entities.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CarInsuranceTest {

    private CarInsurance carInsurance;

    @Before public void setUp() {
    }

    @Test
    public void givenProductList_ByEOD_SellInAndPriceShouldLowers() {
        carInsurance = new CarInsurance(new Product[]{
                new Product("Medium Coverage", 10, 20)
        });

        Product[] products = carInsurance.updatePrice();
        assertThat(products.length, is(1));

        assertThat(products[0].getSellIn(), is(9));
        assertThat(products[0].getPrice(), is(19));
    }
}
