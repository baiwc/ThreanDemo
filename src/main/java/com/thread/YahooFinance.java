package com.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 〈一句话功能简述〉<br>
 * 〈雅虎网址〉
 *
 * @author baiwc
 * @date 2019-09-29 9:39
 * @since 2019.09.29
 */
public class YahooFinance {
    public static double getPrice(final String ticker) throws IOException {
        //final URL url = new URL("https://ichart.finance.yahoo.com/chart/csv?s=" + ticker);
        final URL url= new URL("http://money.finance.sina.com.cn/quotes_service/api/json_v2.php/CN_MarketData.getKLineData?symbol=" + ticker+ "&scale=5&ma=5&datalen=1");

        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        final String discardHeader = bufferedReader.readLine();
        final String data = bufferedReader.readLine();
        final String[] dataItems = data.split(",");
        final double priceIsTheLastValue = Double.valueOf(dataItems.length -1);
        return priceIsTheLastValue;
    }

    public static void main(String[] args) throws IOException{
        final URL url= new URL("http://money.finance.sina.com.cn/quotes_service/api/json_v2.php/CN_MarketData.getKLineData?symbol=SZ300608&scale=5&ma=5&datalen=1");
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        final String discardHeader = bufferedReader.readLine();
        final String data = bufferedReader.readLine();
        final String[] dataItems = data.split(",");

    }
}