package com.thread;

import com.JVM.TestDefault;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试protect修饰符〉
 *
 * @author baiwc
 * @date 2019-11-12 10:27
 * @since 2019.11.12
 */
public class TestProtect extends TestDefault{

    public static void main(String[] args) {
        TestDefault testDefault = new TestDefault();
        //测试同包不同类
//        testDefault.printProtected();
//        testDefault.printDefault();
        //测试子类
        TestProtect testMethod = new TestProtect();
        System.out.println(testMethod.str);

    }
}