package com.anderson.testco.coverage;

import com.anderson.testco.entities.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CommonCoverageTest {

    @InjectMocks CommonCoverage commonCoverage;

    @Test
    public void shouldDecreaseSellInAndPriceNormally_WhenSellByDateHasNotBeenReached() {
        Product result = commonCoverage.apply(new Product("Medium Coverage", 10, 20));

        assertThat(result.getSellIn(), is(9));
        assertThat(result.getPrice(), is(19));
    }

    @Test
    public void shouldDecreasePriceTwiceFaster_WhenSellByDateIsReached() {
        Product result = commonCoverage.apply(new Product("Medium Coverage", 0, 10));

        assertThat(result.getSellIn(), is(-1));
        assertThat(result.getPrice(), is(8));
    }
}
