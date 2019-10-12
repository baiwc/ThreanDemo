package com.thread;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈多线程测试类〉
 *
 * @author baiwc
 * @date 2019-09-26 17:50
 * @since 2019.09.26
 */
public class ConcurrentNAV extends AbstractNAV {
    public double computeNetAssertValue (final Map<String,Integer> stocks)throws InterruptedException,ExecutionException{
        final int numberOfCores  = Runtime.getRuntime().availableProcessors();
        System.out.println("可用线程数量：" + numberOfCores);
        final double blockingRate = 0.9;
        final int poolSize = (int)(numberOfCores/(1 - blockingRate));
        System.out.println("poolSize : " + poolSize);
        final List<Callable<Double>> partitions = new ArrayList<>();
        for(final String ticker : stocks.keySet()){
            partitions.add(new Callable<Double>() {
                @Override
                public Double call() throws Exception {
                    return stocks.get(ticker) * YahooFinance.getPrice(ticker);
                }
            });
        }

        final ExecutorService executorPool = Executors.newFixedThreadPool(poolSize);
        final List<Future<Double>> valueOfStocks = executorPool.invokeAll(partitions,10000,TimeUnit.SECONDS);
        double netAssertValue = 0.0;
        for (final Future<Double> valueOfStock : valueOfStocks){
            netAssertValue += valueOfStock.get();
        }
        executorPool.shutdown();
        return netAssertValue;
    }

    public static void main(final String[] args) throws InterruptedException, ExecutionException, IOException {
        new ConcurrentNAV().timeAndComputeValue();
    }
}