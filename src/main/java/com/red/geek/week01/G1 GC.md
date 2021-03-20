G1 GC

启动参数 `-XX:+UserG1GC -XX:MaxGCPauseMillis=50`

参数配置

```shell
-- 核心参数
## 初始年轻代占整个Java Heap的大小，默认为5%
-XX: G1NewSizePercent
## 最大年轻代占整个Java Heap的大小，默认为60%
-XX: G1MaxNewSizePercent
## 设置每个region的大小，单位MB，默认堆内存的 1/2000
-XX: G1HeapRegionSize
## 与Java应用一起执行的GC线程数量，默认是Java线程的 1/4
-XX: ConcGCThreads
## IHOP，G1内部并行回收循环启动的阈值，默认为Java Heap的45%，可以理解为老年代使用大于等于45%时，JVM会启动垃圾回收
-XX: +InitiatingHeapOccupancyPercent
## G1停止回收的最小内存大小，默认是堆大小的5%。GC会收集所有Region中的对象，但是如果下降到了5%，就会停止下来不收集了
-XX: G1HeapWastePercent
## 计算花在Java应用线程上和花在GC线程上的时间比率，默认是9，跟新生代内存的分配比例一致，表示最多10%的时间会花在GC上
-XX: +GCTimeRatio
预期GC每次执行GC操作的暂停时间，单位是毫秒，默认值是200ms，G1会尽量保证控制在这个范围内
-XX: MaxGCPauseMillis
```

- jmap

  ```shell
  λ jmap -heap 10252
  Attaching to process ID 10252, please wait...
  Debugger attached successfully.
  Server compiler detected.
  JVM version is 25.181-b13
  
  using thread-local object allocation.
  Garbage-First (G1) GC with 8 thread(s)
  
  Heap Configuration:
     MinHeapFreeRatio         = 40
     MaxHeapFreeRatio         = 70
     MaxHeapSize              = 8556380160 (8160.0MB)
     NewSize                  = 1363144 (1.2999954223632812MB)
     MaxNewSize               = 5133828096 (4896.0MB)
     OldSize                  = 5452592 (5.1999969482421875MB)
     NewRatio                 = 2
     SurvivorRatio            = 8
     MetaspaceSize            = 21807104 (20.796875MB)
     CompressedClassSpaceSize = 1073741824 (1024.0MB)
     MaxMetaspaceSize         = 17592186044415 MB
     G1HeapRegionSize         = 2097152 (2.0MB)
  
  Heap Usage:
  G1 Heap:
     regions  = 4080
     capacity = 8556380160 (8160.0MB)
     used     = 235862784 (224.936279296875MB)
     free     = 8320517376 (7935.063720703125MB)
     2.7565720502068016% used
  G1 Young Generation:
  Eden Space:
     regions  = 99
     capacity = 274726912 (262.0MB)
     used     = 207618048 (198.0MB)
     free     = 67108864 (64.0MB)
     75.57251908396947% used
  Survivor Space:
     regions  = 13
     capacity = 27262976 (26.0MB)
     used     = 27262976 (26.0MB)
     free     = 0 (0.0MB)
     100.0% used
  G1 Old Generation:
     regions  = 2
     capacity = 232783872 (222.0MB)
     used     = 981760 (0.936279296875MB)
     free     = 231802112 (221.063720703125MB)
     0.4217474310247748% used
  
  16118 interned Strings occupying 2161880 bytes.
  ```

  

