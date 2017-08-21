package ro.lucas.chapter4.nav;

import java.math.BigDecimal;

public class YahooFinance {
    public static BigDecimal getPrice(final String ticker) {
        //yahoo api is no longer available so i returned a hardcoded value
        return new BigDecimal(101);


        //code if api would be available

//        try {
//            final URL url =
//                    new URL("http://ichart.finance.yahoo.com/table.csv?s=" + ticker);
//            final BufferedReader reader =
//                    new BufferedReader(new InputStreamReader(url.openStream()));
//            final String data = reader.lines().skip(1).findFirst().get();
//            final String[] dataItems = data.split(",");
//            return new BigDecimal(dataItems[dataItems.length - 1]);
//        } catch(Exception ex) {
//            throw new RuntimeException(ex);
//        }
    }
}