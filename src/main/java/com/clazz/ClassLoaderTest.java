package com.clazz;

import java.io.IOException;
import java.io.InputStream;

/**
 * 〈一句话功能简述〉<br>
 * 〈java类加载器与instanceof字段演示〉
 *
 * @author baiwc
 * @date 2019-12-09 11:01
 * @since 2019.12.09
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try{
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream inputStream = getClass().getResourceAsStream(fileName);
                    if (inputStream == null){
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[inputStream.available()];
                    inputStream.read(b);
                    return defineClass(name,b,0,b.length);
                } catch (IOException e){
                    e.printStackTrace();
                    throw new ClassNotFoundException(name);
                }
            }
        };

        try {
            Object obj = myLoader.loadClass("com.clazz.ClassLoaderTest").newInstance();
            System.out.println(obj.getClass());
            System.out.println(obj instanceof ClassLoaderTest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}