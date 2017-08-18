package ro.lucas.chapter5.rodcutter;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RodCutterTest {
    private RodCutter rodCutter = new RodCutter();
    private List<Integer> prices = Arrays.asList(2,3,4,5,6);


    @Test
    void VerboseExceptionTest() {
        rodCutter.setPrices(prices);
        try {
            rodCutter.maxProfit(0);
            fail("Expected exception for zero length");
        } catch (RodCutterException e) {
            assertTrue(true, "expected");
        }
    }

    @Test
    void ConciseExceptionTest(){
        rodCutter.setPrices(prices);
        assertThrows(RodCutterException.class, () -> rodCutter.maxProfit(0));
    }
}
