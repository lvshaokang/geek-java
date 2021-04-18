package com.red.geek.week05.aop;

/**
 * PrintService
 *
 * @author red
 * @class_name PrintService
 * @date 2021-04-18
 */
public class PrintServiceImpl implements PrintService {

    @Override
    public void print() {
        System.out.println("print something");
    }
}
