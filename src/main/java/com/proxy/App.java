package com.proxy;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试类〉
 *
 * @author baiwc
 * @date 2019-12-04 8:39
 * @since 2019.12.04
 */
public class App {

    public static void main(String[] args) {
        IUserDao target = new UserDao();
        System.out.println("原始类型：" + target.getClass());

        //给目标对象创建代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println("代理对象："+ proxy.getClass());

        //执行代理对象的方法
        proxy.save();
    }
}