package ro.lucas.chapter8;

import ro.lucas.chapter4.nav.YahooFinance;

import java.math.BigDecimal;

import static java.util.stream.Collectors.joining;

public class Stocks100 {
    public static void main(String[] args) {
        final BigDecimal HUNDRED = new BigDecimal("100");

        System.out.println("Stock prices over $100 are " +
                    Tickers.symbols.stream()
                                    .filter(symbol -> YahooFinance.getPrice(symbol)
                                            .compareTo(HUNDRED) > 0)
                                    .sorted()
                                    .collect(joining(", ")));
    }
}
