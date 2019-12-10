package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 〈一句话功能简述〉<br>
 * 〈快速失败测试文件〉
 *
 * @author baiwc
 * @date 2019-12-07 14:58
 * @since 2019.12.07
 */
public class FastFailTest {

    private static List<String> list = new CopyOnWriteArrayList<>();

    private  static void printAll(){

        System.out.println("====================");
        String value ;
        Iterator it = list.iterator();
        while (it.hasNext()){
            value = (String)it.next();
            System.out.println("Thread" + Thread.currentThread().getName() +":" + value);
        }

    }

    private static class ThreadOne extends Thread{
        public void run(){
            int i = 0;
            while ( i < 6){
                list.add(String.valueOf(i));
                printAll();
                i ++;
            }
        }

    }

    public static void main(String[] args) {
        new ThreadOne().start();
        new ThreadOne().start();
    }
}