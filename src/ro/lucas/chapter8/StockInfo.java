package ro.lucas.chapter8;

import java.math.BigDecimal;

public class StockInfo {

    private final String ticker;
    final BigDecimal price;

    public StockInfo(String ticker, BigDecimal price) {
        this.ticker = ticker;
        this.price = price;
    }

    public String toString() {
        return String.format("The price of the ticker with thev name of %s is %g ",
                ticker, price);
    }
}
