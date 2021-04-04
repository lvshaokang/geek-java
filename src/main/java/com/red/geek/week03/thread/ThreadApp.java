package com.red.geek.week03.thread;

/**
 * ThreadApp
 *
 * @author red
 * @class_name ThreadApp
 * @date 2021-04-04
 */
public class ThreadApp {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread t = Thread.currentThread();
            System.out.println("当前线程：" + t.getName());
        }, "child-thread");

        // 守护线程在主方法结束时候结束, 自动关闭线程
        thread.setDaemon(true);
        thread.start();

        System.out.println("主线程over");
    }
}
