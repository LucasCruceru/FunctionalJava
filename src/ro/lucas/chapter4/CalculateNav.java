package ro.lucas.chapter4;

import java.math.BigDecimal;
import java.util.function.Function;

class CalculateNav {

    private Function<String, BigDecimal>priceFinder;

    public CalculateNav(Function<String, BigDecimal> priceFinder) {
        this.priceFinder = priceFinder;
    }

    public BigDecimal computerStockWorth(final String ticker, final int shares){
        return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
    }
}
