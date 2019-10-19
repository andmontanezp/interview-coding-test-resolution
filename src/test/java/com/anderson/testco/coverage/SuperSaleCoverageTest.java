package com.anderson.testco.coverage;

import com.anderson.testco.entities.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class SuperSaleCoverageTest {

    @InjectMocks
    SuperSaleCoverage superSaleCoverage;

    @Test
    public void shouldDecreasePriceTwiceFasterThanCommonProducts_WhenCoverageIsApplied_AndSellByDateHasNotBeenReachedYet() {
        Product result = superSaleCoverage.apply(new Product("Super Sale", 3, 6));

        assertThat(result.getSellIn(), is(2));
        assertThat(result.getPrice(), is(4));
    }

    @Test
    public void shouldDecreasePriceTwiceFasterThanCommonProducts_WhenCoverageIsApplied_AndSellByDateIsReached() {
        Product result = superSaleCoverage.apply(new Product("Super Sale", 0, 6));

        assertThat(result.getSellIn(), is(-1));
        assertThat(result.getPrice(), is(2));
    }
}
