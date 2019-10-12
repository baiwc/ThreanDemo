package com.thread;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * 〈一句话功能简述〉<br>
 * 〈线程池测试类〉
 *
 * @author baiwc
 * @date 2019-09-26 17:38
 * @since 2019.09.26
 */
public abstract class AbstractNAV {

    public static Map<String,Integer> readTickers() throws IOException {
        final BufferedReader reader = new BufferedReader(new FileReader("E:\\ideawork\\github\\demo\\src\\main\\java\\com\\thread\\stacks.txt"));
        final Map<String,Integer> stocks = new HashMap<>();
        String stockInfo = null;
        while ((stockInfo = reader.readLine()) != null){
            final String[] stockInfoData = stockInfo.split(",");
            final String stockTicker = stockInfoData[0];
            final Integer quantity = Integer.parseInt(stockInfoData[1]);
            stocks.put(stockTicker,quantity);
        }
        return stocks;
    }

    public void timeAndComputeValue() throws IOException, ExecutionException, InterruptedException {
        final long start = System.nanoTime();
        final Map<String,Integer> stocks = readTickers();
        final double nav = computeNetAssertValue(stocks);

        final long end = System.nanoTime();

        final String value = new DecimalFormat("$##,##0.00").format(nav);
        System.out.println("Your net assert value is : " + value);
        System.out.println("Time (second ) taken : " + (end - start) / 1.0e9);
    }

    public abstract double computeNetAssertValue(final Map<String,Integer> stocks) throws ExecutionException,InterruptedException, IOException;

}