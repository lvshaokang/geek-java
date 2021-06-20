package com.red.geek.week11;

import lombok.extern.slf4j.Slf4j;

/**
 * LockApp
 *
 * @author red
 * @class_name LockApp
 * @date 2021-06-20
 */
@Slf4j
public class LockApp {
    private static final RedisLock lock = RedisLock.Singleton.INSTANCE.getSingleton();

    private static int amount = 10;

    public static void lock() {
        if (lock.lock("redis_lock", 3)) {
            System.out.println("获取锁失败");
        }

        try {
            Thread.sleep(10000);
            amount -= 1;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock.release("redis_lock");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> lock());
        Thread thread2 = new Thread(() -> lock());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

}
