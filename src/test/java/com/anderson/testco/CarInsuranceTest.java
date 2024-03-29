package com.anderson.testco;

import com.anderson.testco.entities.Product;
import com.anderson.testco.insurance.CarInsurance;
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

    @Test
    public void givenProductList_WhenSellByDateHasPassed_PriceShouldDegradesTwiceFaster() {
        carInsurance = new CarInsurance(new Product[]{
                new Product("Medium Coverage", 0, 20)
        });

        Product[] products = carInsurance.updatePrice();
        assertThat(products.length, is(1));

        assertThat(products[0].getSellIn(), is(-1));
        assertThat(products[0].getPrice(), is(18));
    }

   @Test
   public void givenProduct_WhenUpdatePrice_PriceShouldNeverBeNegative() {
       carInsurance = new CarInsurance(new Product[]{
               new Product("Medium Coverage", 0, 0)
       });

       Product[] products = carInsurance.updatePrice();
       assertThat(products.length, is(1));

       assertThat(products[0].getSellIn(), is(-1));
       assertThat(products[0].getPrice(), is(0));
   }

    @Test
    public void givenProduct_WhenIsFullCoverage_ShouldIncreaseInPriceAsItGetsOlder() {
        carInsurance = new CarInsurance(new Product[]{
                new Product("Full Coverage", 0, 2)
        });

        Product[] products = carInsurance.updatePrice();
        assertThat(products.length, is(1));

        assertThat(products[0].getSellIn(), is(-1));
        assertThat(products[0].getPrice(), is(4));
    }

    @Test
    public void givenProduct_WhenUpdatePrice_ShouldNeverBeHigherThan50() {
        carInsurance = new CarInsurance(new Product[]{
                new Product("Full Coverage", 0, 50)
        });

        Product[] products = carInsurance.updatePrice();
        assertThat(products.length, is(1));

        assertThat(products[0].getSellIn(), is(-1));
        assertThat(products[0].getPrice(), is(50));
    }

    @Test
    public void givenProduct_WhenIsMegaCoverage_ShouldNotBeChangedAtAll() {
        carInsurance = new CarInsurance(new Product[]{
                new Product("Mega Coverage", 0, 80)
        });

        Product[] products = carInsurance.updatePrice();
        assertThat(products.length, is(1));

        assertThat(products[0].getSellIn(), is(0));
        assertThat(products[0].getPrice(), is(80));
    }

    @Test
    public void givenProduct_WhenIsSpecialFullCoverage_AndSellinIsHigherThan10Days_ShouldBehaveLikeFullCoverage() {
        carInsurance = new CarInsurance(new Product[]{
                new Product("Special Full Coverage", 11, 24)
        });

        Product[] products = carInsurance.updatePrice();

        assertThat(products.length, is(1));

        assertThat(products[0].getSellIn(), is(10));
        assertThat(products[0].getPrice(), is(25));
    }

    @Test
    public void givenProduct_WhenIsSpecialFullCoverage_AndSellinIs10DaysOrLower_ShouldDoubleIncreasePrice() {
        carInsurance = new CarInsurance(new Product[]{
                new Product("Special Full Coverage", 10, 25)
        });

        Product[] products = carInsurance.updatePrice();

        assertThat(products.length, is(1));

        assertThat(products[0].getSellIn(), is(9));
        assertThat(products[0].getPrice(), is(27));
    }

    @Test
    public void givenProduct_WhenIsSpecialFullCoverage_AndSellinIs5DaysOrLower_ShouldTripleIncreasePrice() {
        carInsurance = new CarInsurance(new Product[]{
                new Product("Special Full Coverage", 5, 35)
        });

        Product[] products = carInsurance.updatePrice();

        assertThat(products.length, is(1));

        assertThat(products[0].getSellIn(), is(4));
        assertThat(products[0].getPrice(), is(38));
    }

    @Test
    public void givenProduct_WhenIsSpecialFullCoverage_AndSellinIsNegative_ShouldInvalidateProduct() {
        carInsurance = new CarInsurance(new Product[]{
                new Product("Special Full Coverage", 0, 50)
        });

        Product[] products = carInsurance.updatePrice();

        assertThat(products.length, is(1));

        assertThat(products[0].getSellIn(), is(-1));
        assertThat(products[0].getPrice(), is(0));
    }

    @Test
    public void xxx() {
        carInsurance = new CarInsurance(new Product[]{
                new Product("Special Full Coverage", 0, 50)
        });
    }
}