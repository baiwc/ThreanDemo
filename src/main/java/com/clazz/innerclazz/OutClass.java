package com.clazz.innerclazz;

import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试学习内部类〉
 *
 * @author baiwc
 * @date 2019-12-12 15:16
 * @since 2019.12.12
 */
public class OutClass {



    public static class InnerClass{

        private static int type = 0;

        Map<String,Object> hashMap = new HashMap<>();
        Set set = new HashSet();
        Set set1 = new TreeSet();
    }
}