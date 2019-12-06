package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 〈一句话功能简述〉<br>
 * 〈代理工厂〉
 *
 * @author baiwc
 * @date 2019-12-02 15:31
 * @since 2019.12.02
 */
public class ProxyFactory {

    //维护一个目标对象
    private Object target;

    public ProxyFactory(Object object){
        this.target = object;
    }

    //给目标对象生产代理对象
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开始事务：：：");
                Object returnValue = method.invoke(target,args);
                System.out.println("提交事务：：：：");
                return returnValue;
            }
        });
    }
}