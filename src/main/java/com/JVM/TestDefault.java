package com.JVM;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试default修饰符〉
 *
 * @author baiwc
 * @date 2019-11-12 10:27
 * @since 2019.11.12
 */
public class TestDefault {

    protected String str = "protected";

    String string = "default";

    private String one =  "private";

    protected void printProtected(){
        System.out.println("This is protected method!!");
    }

    void printDefault(){
        System.out.println("This is default method !!");
    }
}