package ro.lucas.chapter4.nav;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateNAVTest {
    @Test
    void computeStockWorth(){
        final CalculateNav calculateNAV = new CalculateNav(
                ticker -> new BigDecimal("6.01"));
        BigDecimal expected = new BigDecimal("6010.00");
        assertEquals(0,calculateNAV.computeStockWorth("GOOG",1000)
                        .compareTo(expected),
                0.001);
    }
}
