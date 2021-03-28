#### GC 共性

设置的-Xmx越小，full GC的次数会提升，甚至OOM

堆内存越大，对象数量越多，发生Full GC时间的时间可能会愈加增长

#### 串行GC

java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:-UseAdaptiveSizePolicy -Xmx512m -Xms512m -XX:+UseSerialGC com.red.geek.week02.GCLogAnalysis
YonngGC与Full GC所用时间基本相同，

#### 并行GC
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:-UseAdaptiveSizePolicy -Xmx512m -Xms512m -XX:+UseParallelGC com.red.geek.week02.GCLogAnalysis

由于并行化执行GC，YonngGC的时间对比串行GC有所减少，但Full GC时间相差无几，发生FullGC时，会伴随着一次YoungGC

#### CMS GC
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:-UseAdaptiveSizePolicy -Xmx512m -Xms512m -XX:+UseConcMarkSweepGC com.red.geek.week02.GCLogAnalysis

CMS GC，老年代回收器，高并发、低停顿，追求最短的GC回收停顿时间，增加堆内存时，提升速率变低

#### G1 GC
java -XX:+PrintGC -XX:+PrintGCDateStamps -XX:-UseAdaptiveSizePolicy -Xmx512m -Xms512m -XX:+UseG1GC com.red.geek.week02.GCLogAnalysis

G1通过划分多个内存区域做**增量**整理和回收，进一步降低延迟

对比与其他GC，同样512m堆内存大小下，G1在垃圾回收速度方面有所提升

G1有可能会退换成串行化，极大降低回收效率，使用时需要防止退化。