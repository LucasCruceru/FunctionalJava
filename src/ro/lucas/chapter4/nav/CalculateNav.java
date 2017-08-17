package ro.lucas.chapter4.nav;

import java.math.BigDecimal;
import java.util.function.Function;

class CalculateNav {

    private Function<String, BigDecimal>priceFinder;

    CalculateNav(Function<String, BigDecimal> priceFinder) {
        this.priceFinder = priceFinder;
    }

    BigDecimal computeStockWorth(final String ticker, final int shares){
        return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
    }

    public static void main(String[] args) {
        final CalculateNav calculateNav = new CalculateNav(YahooFinance::getPrice);
        System.out.println(String.format("100 shares of Google worth: $%.2f",
                calculateNav.computeStockWorth("GOOG", 100)));
    }

}
