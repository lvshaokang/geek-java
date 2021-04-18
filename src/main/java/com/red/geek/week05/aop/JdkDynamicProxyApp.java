package com.red.geek.week05.aop;

import io.netty.handler.proxy.ProxyHandler;

import java.lang.reflect.Proxy;


/**
 * JdkDynamicProxyApp
 *
 * @author red
 * @class_name JdkDynamicProxyApp
 * @date 2021-04-18
 */
public class JdkDynamicProxyApp {
    public static void main(String[] args) {
        PrintServiceImpl service = new PrintServiceImpl();
        ClassLoader classLoader = service.getClass().getClassLoader();
        Class<?>[] interfaces = service.getClass().getInterfaces();
        JdkDynamicProxyHandler proxyHandler = new JdkDynamicProxyHandler(service);
        PrintService proxy = (PrintService) Proxy.newProxyInstance(classLoader, interfaces, proxyHandler);
        proxy.print();
    }
}
