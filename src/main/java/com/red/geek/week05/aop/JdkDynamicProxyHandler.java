package com.red.geek.week05.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JdkDynamicProxyHandler
 *
 * @author red
 * @class_name JdkDynamicProxyHandler
 * @date 2021-04-17
 */
public class JdkDynamicProxyHandler implements InvocationHandler {
    private Object object;

    public JdkDynamicProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(object, args);
        after();
        return null;
    }

    private void before() {
        System.out.println("before something");
    }

    private void after() {
        System.out.println("after something");
    }
}
