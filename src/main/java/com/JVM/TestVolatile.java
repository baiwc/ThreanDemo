package com.JVM;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试volatile关键字〉
 *
 * @author baiwc
 * @date 2019-11-12 15:49
 * @since 2019.11.12
 */
public class TestVolatile {

    private volatile boolean stop = false;

    private volatile int num = 0;

    public void foo(){
        num = 100;
        stop = true;
    }
    public void bar(){
        if (stop){
            num += num;
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        TestVolatile testVolatile = new TestVolatile();
        testVolatile.foo();
        testVolatile.bar();
    }
}