package ro.lucas.chapter8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static ro.lucas.chapter8.Tickers.symbols;

public class PickStockImperative {
    private static final List<StockInfo> stocks = new ArrayList<>();

    public static void main(String[] args) {

        final Predicate<StockInfo> isPriceLessThan500 = StockUtil.isPriceLessThan(500);
        StockInfo highPriced = new StockInfo("", BigDecimal.ZERO);

        System.out.println("---------------------------Long imperative style-----------------------------------");
        longImperative(isPriceLessThan500, highPriced);


        System.out.println("\n" +"---------------------------Short imperative style----------------------------------");
        shortImperative(isPriceLessThan500, highPriced);

        System.out.println("\n" +"---------------------------Functional style----------------------------------------");
        functional(symbols.stream());

    }

    private static void longImperative(Predicate<StockInfo> isPriceLessThan500, StockInfo highPriced) {
        final List<StockInfo> stocksPriceUnder500 = new ArrayList<>();
        for(String symbol : symbols) {
            stocks.add(StockUtil.getPrice(symbol));
        }
        for (StockInfo stock: stocks){
            if (isPriceLessThan500.test(stock))
                stocksPriceUnder500.add(stock);
        }
        for (StockInfo stock: stocksPriceUnder500) {
            highPriced = StockUtil.pickHigh(highPriced, stock);
        }
        System.out.println("High priced under $500 is " + highPriced);

    }

    private static void shortImperative(Predicate<StockInfo> isPriceLessThan500, StockInfo highPriced) {
        for (String symbol : symbols ) {
            StockInfo stockInfo = StockUtil.getPrice(symbol);
            if (isPriceLessThan500.test(stockInfo))
                highPriced = StockUtil.pickHigh(highPriced,stockInfo);
        }
        System.out.println("High priced under $500 is " + highPriced);
    }

    private static void functional(final Stream<String> symbols){
        final StockInfo highPriced =
                symbols.map(StockUtil::getPrice)
                        .filter(StockUtil.isPriceLessThan(500))
                        .reduce(StockUtil::pickHigh)
                        .get();

        System.out.println("High priced under $500 is " + highPriced);
    }
}
