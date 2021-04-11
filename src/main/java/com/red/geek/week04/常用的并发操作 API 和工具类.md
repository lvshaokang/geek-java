### synchronized

同步锁，无法控制超时，灵活度较低



### Lock

使用方式自由，能够响应中断、支持超时、非阻塞地获取锁



### Semaphore

信号量，同时时间可控制并发线程数



### CountDownLatch

解决一个线程等待多个线程的场景，比如 Master 线程等待 Worker 线程把任务执行完



### CyclicBarrier

是一组线程之间互相等待，计数器可循环使用



### Future/FutureTask/CompletableFuture

Future/FutureTask 很容易的获得异步任务的执行结果，无论异步任务是通过线程池执行的，还是通过手工创建子线程执行的

CompletableFuture  异步编程，无需手工维护线程，没有繁琐的手工维护线程的工作，语义更清晰，代码更专注于业务逻辑

