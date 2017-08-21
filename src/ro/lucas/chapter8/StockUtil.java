package ro.lucas.chapter8;

import ro.lucas.chapter4.nav.YahooFinance;

import java.math.BigDecimal;
import java.util.function.Predicate;

class StockUtil {
    static StockInfo getPrice(final String ticker){
        return  new StockInfo(ticker, YahooFinance.getPrice(ticker));
    }
    static Predicate<StockInfo> isPriceLessThan(final int price){
       return stockInfo -> stockInfo.price.compareTo(BigDecimal.valueOf(price)) < 0;
    }
    static StockInfo pickHigh(final StockInfo stock1, final StockInfo stock2){
        return stock1.price.compareTo(stock2.price) > 0 ? stock1 : stock2;
    }
}
