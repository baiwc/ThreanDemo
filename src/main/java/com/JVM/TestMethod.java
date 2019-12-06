package com.JVM;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试修饰符类〉
 *
 * @author baiwc
 * @date 2019-11-12 10:31
 * @since 2019.11.12
 */
public class TestMethod extends TestDefault {
    public static void main(String[] args) {
        TestDefault testDefault = new TestDefault();
        //测试同包不同类
        testDefault.printProtected();
        testDefault.printDefault();
        //测试子类
        TestMethod testMethod = new TestMethod();
        System.out.println(testMethod.str);
        System.out.println(testMethod.string);
    }
}