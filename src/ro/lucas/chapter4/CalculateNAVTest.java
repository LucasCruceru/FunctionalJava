package ro.lucas.chapter4;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateNAVTest {
    @Test
    public void computeStockWorth(){
        final CalculateNav calculateNAV = new CalculateNav(
                ticker -> new BigDecimal("6.01"));
        BigDecimal expected = new BigDecimal("6010.00");
        assertEquals(0,calculateNAV.computerStockWorth("GOOG",1000)
                        .compareTo(expected),
                0.001);
    }
}
