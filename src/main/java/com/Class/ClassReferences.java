package com.Class;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈class类型的引用〉
 *
 * @author baiwc
 * @date 2019-11-16 22:26
 * @since 2019.11.16
 */
public class ClassReferences<T> {

    /**
     * class泛型
     */
    private Class<T> type;

    //构造方法
    public ClassReferences(Class<T> type){
        this.type = type;
    }

    public List<T> create(int nElements) {
        List<T> result = new ArrayList<>();
        try {
            for (int i = 0; i < nElements; i++) {
                result.add(type.newInstance());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return result;
    }

    public  void Test() {
        //普通的类引用可以指向任何其他的Class对象，但是使用泛型类引用只能赋值为指向声明的类
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = int.class;
        genericIntClass = Integer.class;
        /**
        genericIntClass = double.class;
        */
        intClass = Integer.class;
        intClass = double.class;

        //通过继承呢？Integer继承Number  但是Integer.class 并不是Number.class的子类

//        Class<Number> genericNumberClass = int.class;
        //通配符 没有问题
        Class<?> intClass1 = int.class;
        intClass1 = double.class;
        Class<? extends Number> numberClass = Integer.class;
        numberClass = double.class;
        numberClass = Double.class;
        numberClass = Number.class;
    }

    public static void main(String[] args) {
//        ClassReferences<CountedInteger> cr = new ClassReferences<>(CountedInteger.class);
//        System.out.println(cr.create(10));

    }

}

/**
 *
 */
class CountedInteger{
    private static long counter;
    private final long id = counter ++ ;
    public String toString(){
        return Long.toString(id);
    }
    public CountedInteger(int i){
        System.out.println("构造函数参数值 ： " + i);
    }
}

interface HasBatteries{

}

interface Waterproof{

}

interface Shoots{

}

class FancyToy extends Toy implements HasBatteries,Waterproof,Shoots{
    FancyToy(){
        super(1);
    }
}

class Toy{
    Toy(){}
    Toy(int i){
    }
}