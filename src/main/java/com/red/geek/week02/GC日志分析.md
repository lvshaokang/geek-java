**为了方便运算，本文中1000kb=1m**



## 串行GC

java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:-UseAdaptiveSizePolicy -Xmx512m -Xms512m -XX:+UseSerialGC com.red.geek.week02.GCLogAnalysis

GC示例，日志解读

```shell
## YGC，暂停了9ms，Young区内存（总共39M） 34M 回收到 4M，堆内存（126M） 34M 回收到 12M，即，有8M晋升到Old区
2021-03-26T01:42:43.532+0800: [GC (Allocation Failure) 2021-03-26T01:42:43.532+0800: [DefNew: 34884K->4352K(39296K), 0.0090885 secs] 34884K->12930K(126720K), 0.0091610 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2021-03-26T01:42:43.554+0800: [GC (Allocation Failure) 2021-03-26T01:42:43.554+0800: [DefNew: 39289K->4345K(39296K), 0.0107330 secs] 47868K->24820K(126720K), 0.0107680 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
...
2021-03-26T01:42:43.619+0800: [GC (Allocation Failure) 2021-03-26T01:42:43.619+0800: [DefNew: 39273K->4343K(39296K), 0.0079035 secs] 92091K->68025K(126720K), 0.0079522 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2021-03-26T01:42:43.633+0800: [GC (Allocation Failure) 2021-03-26T01:42:43.633+0800: [DefNew: 38926K->4344K(39296K), 0.0073886 secs] 102608K->78954K(126720K), 0.0074230 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
## Old区内存（总共87M），74M 回收到 85M
2021-03-26T01:42:43.648+0800: [GC (Allocation Failure) 2021-03-26T01:42:43.648+0800: [DefNew: 39232K->39232K(39296K), 0.0000194 secs]2021-03-26T01:42:43.648+0800: [Tenured: 74610K->85408K(87424K), 0.0149275 secs] 113843K->85408K(126720K), [Metaspace: 2694K->2694K(1056768K)], 0.0150050 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
## Old区内存（总共87M），74M 回收到 87M
2021-03-26T01:42:43.668+0800: [GC (Allocation Failure) 2021-03-26T01:42:43.668+0800: [DefNew: 34723K->34723K(39296K), 0.0000199 secs]2021-03-26T01:42:43.668+0800: [Tenured: 85408K->87354K(87424K), 0.0116942 secs] 120131K->96190K(126720K), [Metaspace: 2694K->2694K(1056768K)], 0.0117867 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
## 发生FullGC Old区内存（总共87M），87M 回收到 87M
2021-03-26T01:42:43.684+0800: [Full GC (Allocation Failure) 2021-03-26T01:42:43.684+0800: [Tenured: 87354K->87162K(87424K), 0.0120432 secs] 126628K->103537K(126720K), [Metaspace: 2694K->2694K(1056768K)], 0.0121184 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2021-03-26T01:42:43.699+0800: [Full GC (Allocation Failure) 2021-03-26T01:42:43.699+0800: [Tenured: 87306K->87371K(87424K), 0.0147919 secs] 126526K->106930K(126720K), [Metaspace: 2694K->2694K(1056768K)], 0.0148374 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
```



## 并行GC
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:-UseAdaptiveSizePolicy -Xmx512m -Xms512m -XX:+UseParallelGC com.red.geek.week02.GCLogAnalysis

- YoungGC 示例

  ```shell
  2021-03-26T00:34:15.698+0800: [GC (Allocation Failure) [PSYoungGen: 131584K->21502K(153088K)] 131584K->40665K(502784K), 0.0078483 secs] [Times: user=0.06 sys=0.05, real=0.01 secs]
  2021-03-26T00:34:15.725+0800: [GC (Allocation Failure) [PSYoungGen: 152813K->21502K(153088K)] 171976K->83378K(502784K), 0.0104682 secs] [Times: user=0.06 sys=0.06, real=0.01 secs]
  ```

  日志解读：

  [PSYoungGen: 131584K->21502K(153088K)] 131584K->40665K(502784K), 0.0078483 secs]

  YGC，暂停了7ms，Young区内存（总共153M） 131M 回收到 21M，堆内存（502M） 131M 回收到 40M，即，有20M晋升到Old区

- FullGC示例

  ```shell
  2021-03-26T00:34:15.923+0800: [Full GC (Ergonomics) [PSYoungGen: 21498K->0K(153088K)] [ParOldGen: 322888K->245207K(349696K)] 344386K->245207K(502784K), [Metaspace: 2694K->2694K(1056768K)], 0.0308520 secs] [Times: user=0.19 sys=0.00, real=0.03 secs]
  ```

  日志解读：FullGC=YGC+OldGC

  [PSYoungGen: 21498K->0K(153088K)] [ParOldGen: 322888K->245207K(349696K)] 344386K->245207K(502784K), [Metaspace: 2694K->2694K(1056768K), 0.0308520 secs]

  FullGC，暂停了30ms，Young区内存（总共153M）21M 回收到 0M，Old区内存（总共349M）322M 回收到 245M，堆内存（总共502M）344M 回收到 245M

  

  当我们修改参数为 -Xmx128m -Xms128m，运行后，发现多次FullGC以后，出现了 OOM 异常，同时，很明显可以观察到堆内存已经占满  120414K->120136K(125952K)，基本没有回收空间

  ```shell
  2021-03-26T00:54:54.423+0800: [Full GC (Ergonomics) [PSYoungGen: 33232K->33098K(38400K)] [ParOldGen: 87182K->87038K(87552K)] 120414K->120136K(125952K), [Metaspace: 2694K->2694K(1056768K)], 0.0018581 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
  2021-03-26T00:54:54.425+0800: [Full GC (Allocation Failure) [PSYoungGen: 33098K->33098K(38400K)] [ParOldGen: 87038K->87019K(87552K)] 120136K->120117K(125952K), [Metaspace: 2694K->2694K(1056768K)], 0.0161090 secs] [Times: user=0.11 sys=0.00, real=0.02 secs]
  Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
          at com.red.geek.week02.GCLogAnalysis.generateGarbage(GCLogAnalysis.java:49)
          at com.red.geek.week02.GCLogAnalysis.main(GCLogAnalysis.java:26)
  ```

  

## CMS GC

java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:-UseAdaptiveSizePolicy -Xmx512m -Xms512m -XX:+UseConcMarkSweepGC com.red.geek.week02.GCLogAnalysis

- YoungGC 示例

  ```shell
  2021-03-26T01:01:31.898+0800: [GC (Allocation Failure) 2021-03-26T01:01:31.898+0800: [ParNew: 139776K->17471K(157248K), 0.0099641 secs] 139776K->48244K(506816K), 0.0100309 secs] [Times: user=0.03 sys=0.08, real=0.01 secs]
  2021-03-26T01:01:31.930+0800: [GC (Allocation Failure) 2021-03-26T01:01:31.930+0800: [ParNew: 157247K->17467K(157248K), 0.0154075 secs] 188020K->91404K(506816K), 0.0154550 secs] [Times: user=0.03 sys=0.08, real=0.02 secs]
  2021-03-26T01:01:31.966+0800: [GC (Allocation Failure) 2021-03-26T01:01:31.966+0800: [ParNew: 157243K->17472K(157248K), 0.0327829 secs] 231180K->135698K(506816K), 0.0328437 secs] [Times: user=0.17 sys=0.03, real=0.03 secs]
  2021-03-26T01:01:32.019+0800: [GC (Allocation Failure) 2021-03-26T01:01:32.019+0800: [ParNew: 157183K->17472K(157248K), 0.0317375 secs] 275409K->177504K(506816K), 0.0317773 secs] [Times: user=0.13 sys=0.03, real=0.03 secs]
  2021-03-26T01:01:32.069+0800: [GC (Allocation Failure) 2021-03-26T01:01:32.069+0800: [ParNew: 157248K->17471K(157248K), 0.0316385 secs] 317280K->219224K(506816K), 0.0316852 secs] [Times: user=0.17 sys=0.02, real=0.03 secs]
  ```

  日志解读：

  [ParNew: 139776K->17471K(157248K), 0.0099641 secs] 139776K->48244K(506816K), 0.0100309 secs]

  ParNew 收集器，

  YGC，暂停了10ms，Young区内存（总共157M） 139M 回收到 17M，堆内存（506M） 139M 回收到 48M

- FullGC 示例+日志解读（YGC+OGC）

  ```shell
  ## CMS 初始化标记阶段，Old区 201M，堆内存 219M，暂停0.4ms
  2021-03-26T01:01:32.101+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 201753K(349568K)] 219934K(506816K), 0.0004986 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
  ## 并发标记
  2021-03-26T01:01:32.102+0800: [CMS-concurrent-mark-start]
  2021-03-26T01:01:32.104+0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
  ## 并发预清理
  2021-03-26T01:01:32.104+0800: [CMS-concurrent-preclean-start]
  2021-03-26T01:01:32.104+0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
  ## 子阶段，可取消的预清理
  2021-03-26T01:01:32.104+0800: [CMS-concurrent-abortable-preclean-start]
  ## 发生了多次的 YGC
  2021-03-26T01:01:32.121+0800: [GC (Allocation Failure) 2021-03-26T01:01:32.121+0800: [ParNew: 157247K->17471K(157248K), 0.0335486 secs] 359000K->265619K(506816K), 0.0336049 secs] [Times: user=0.17 sys=0.05, real=0.03 secs]
  2021-03-26T01:01:32.170+0800: [GC (Allocation Failure) 2021-03-26T01:01:32.170+0800: [ParNew: 157247K->17471K(157248K), 0.0330308 secs] 405395K->307893K(506816K), 0.0330982 secs] [Times: user=0.26 sys=0.01, real=0.03 secs]
  2021-03-26T01:01:32.221+0800: [GC (Allocation Failure) 2021-03-26T01:01:32.221+0800: [ParNew: 157247K->17471K(157248K), 0.0342923 secs] 447669K->354712K(506816K), 0.0343356 secs] [Times: user=0.14 sys=0.03, real=0.04 secs]
  ## 子阶段，可取消的预清理
  2021-03-26T01:01:32.256+0800: [CMS-concurrent-abortable-preclean: 0.003/0.152 secs] [Times: user=0.64 sys=0.09, real=0.15 secs]
  ## CMS 最终标记阶段
  2021-03-26T01:01:32.256+0800: [GC (CMS Final Remark) [YG occupancy: 20972 K (157248 K)]2021-03-26T01:01:32.256+0800: [Rescan (parallel) , 0.0003297 secs]2021-03-26T01:01:32.256+0800: [weak refs processing, 0.0000225 secs]2021-03-26T01:01:32.256+0800: [class unloading, 0.0002342 secs]2021-03-26T01:01:32.257+0800: [scrub symbol table, 0.0003104 secs]2021-03-26T01:01:32.257+0800: [scrub string table, 0.0001015 secs][1 CMS-remark: 337241K(349568K)] 358213K(506816K), 0.0010940 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
  ## 并发清理
  2021-03-26T01:01:32.257+0800: [CMS-concurrent-sweep-start]
  2021-03-26T01:01:32.258+0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
  ## 并发重置
  2021-03-26T01:01:32.258+0800: [CMS-concurrent-reset-start]
  2021-03-26T01:01:32.259+0800: [CMS-concurrent-reset: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
  ```

  注：

  CMS 初始化标记阶段和CMS 最终标记阶段发生了暂停，其他阶段并发执行



## G1 GC

java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:-UseAdaptiveSizePolicy -Xmx512m -Xms512m -XX:+UseG1GC com.red.geek.week02.GCLogAnalysis

java -XX:+PrintGC -XX:+PrintGCDateStamps -XX:-UseAdaptiveSizePolicy -Xmx128m -Xms128m -XX:+UseG1GC com.red.geek.week02.GCLogAnalysis

GC示例，日志解读

```shell
## G1 Evacuation Pause (young) 纯年轻代模式转移暂停
2021-03-26T01:34:09.414+0800: [GC pause (G1 Evacuation Pause) (young) 29M->12M(128M), 0.0042573 secs]
2021-03-26T01:34:09.426+0800: [GC pause (G1 Evacuation Pause) (young) 40M->24M(128M), 0.0035813 secs]
2021-03-26T01:34:09.454+0800: [GC pause (G1 Evacuation Pause) (young) 71M->40M(128M), 0.0039730 secs]
## 并发标记流程
## 1.大对象的分配失败，导致启动了G1的初始化标记 initial-mark
2021-03-26T01:34:09.470+0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 90M->56M(128M), 0.0051803 secs]
## 2.Root区扫描
2021-03-26T01:34:09.475+0800: [GC concurrent-root-region-scan-start]
2021-03-26T01:34:09.475+0800: [GC concurrent-root-region-scan-end, 0.0003227 secs]
## 3.并发标记
2021-03-26T01:34:09.475+0800: [GC concurrent-mark-start]
2021-03-26T01:34:09.477+0800: [GC concurrent-mark-end, 0.0015215 secs]
## 4.再次标记
2021-03-26T01:34:09.477+0800: [GC remark, 0.0019300 secs]
## 5.清理
2021-03-26T01:34:09.479+0800: [GC cleanup 69M->69M(128M), 0.0011913 secs]
...
## G1 Evacuation Pause (mixed) 转移暂停：混合模式
2021-03-26T01:34:09.505+0800: [GC pause (G1 Evacuation Pause) (mixed) 92M->80M(128M), 0.0023215 secs]
...
2021-03-26T01:34:09.567+0800: [GC pause (G1 Evacuation Pause) (young) 113M->113M(128M), 0.0007354 secs]
## FullGC，最坏的情况下，可能退化成串行化
2021-03-26T01:34:09.567+0800: [Full GC (Allocation Failure)  113M->96M(128M), 0.0120289 secs]
```

