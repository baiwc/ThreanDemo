package com.jvm;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试jvm参数〉
 *
 * @author baiwc
 * @date 2019-11-08 15:07
 * @since 2019.11.08
 */
public class TestAllocation {

    private static final int _1MB = 1024 * 1024;

    public static void testAllocation(){
        byte [] allocation1, allocation2, allocation3, allocation4, allocation5;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        TestAllocation.testAllocation();
    }
}