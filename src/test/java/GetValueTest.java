import org.junit.Test;

import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * 思考有多少种方式，在 main 函数启动一个新线程，运行一个方法，拿到这
 * 个方法的返回值后，退出主线程?
 *
 * @author red
 * @class_name TestApp
 * @date 2021-04-11
 */
public class GetValueTest {

    // Future
    @Test
    public void test1() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池
        Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return fibo(36);
            }

            private int fibo(int a) {
                if (a < 2)
                    return 1;
                return fibo(a - 1) + fibo(a - 2);
            }
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 异步执行 下面方法
        Future<Integer> future = executorService.submit(task);
        //这是得到的返回值
        int result = future.get();
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

    // CountDownLatch
    @Test
    public void test2() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池
        int num = 10;
        CountDownLatch countDownLatch = new CountDownLatch(num);
        Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = fibo(36);
                countDownLatch.countDown();
                return result;
            }

            public int fibo(int a) {
                if (a < 2) {
                    return 1;
                }
                return fibo(a - 1) + fibo(a - 2);
            }
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 异步执行 下面方法
        Future<Integer> future = executorService.submit(task);
        //这是得到的返回值
        countDownLatch.await(1,TimeUnit.SECONDS);
        int result = future.get();
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

    // CyclicBarrier
    @Test
    public void test3() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池
        int num = 1;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(num);
        Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = fibo(36);
                cyclicBarrier.await(1, TimeUnit.SECONDS);
                return result;
            }

            public int fibo(int a) {
                if (a < 2) {
                    return 1;
                }
                return fibo(a - 1) + fibo(a - 2);
            }
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 异步执行 下面方法
        Future<Integer> future = executorService.submit(task);
        //这是得到的返回值
        int result = future.get();
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

    // CompletableFuture
    @Test
    public void test4() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return fibo(36);
            }

            private int fibo(int a) {
                if (a < 2) {
                    return 1;
                }
                return fibo(a - 1) + fibo(a - 2);
            }

        }, Executors.newCachedThreadPool());
        Integer result = completableFuture.get();
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
