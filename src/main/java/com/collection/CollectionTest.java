package com.collection;

import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈集合测试类〉
 *
 * @author baiwc
 * @date 2019-10-08 11:48
 * @since 2019.10.08
 */
public class CollectionTest {

    public void TestList(){
        Enumeration enumeration = new Enumeration() {
            @Override
            public boolean hasMoreElements() {
                return false;
            }

        @Override
        public Object nextElement() {
            return null;
        }
    };

    List list = new ArrayList();
        list.add("99809");
        list.add("1111");

    }

    public void TestMap(){
        HashMap map = new HashMap();
        String sre = "2222";
        String srr = "1111";
        System.out.println(sre.equals(srr));
    }

    public void TestSet(){
        Set se = new HashSet();
        se.add("11");
        Integer a= 10;

    }

    public static void main(String[] args) {
        System.out.println(2^4);
    }

}