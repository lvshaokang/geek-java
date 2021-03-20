
- jps -mlv

- jinfo 

- jstack 查看线程信息

- jstat 统计信息
```shell
jstat -<option> [-t] [-h<lines>] <vmid> [<interval> [<count>]]

- gc GC 相关信息 字节数kb
                  
λ jstat -gc 27308 1000 1000 (间隔1s, 打印1000次)

Timestamp   S0C     S1C      S0U(S0区使用量)    S1U      EC       EU        OC         OU       MC     MU    CCSC   CCSU   YGC     YGCT    FGC    FGCT     GCT
1925.1      19968.0 21504.0  0.0    0.0   518656.0 53435.2   238080.0   19608.3   35416.0 33790.8 4736.0 4328.1      5    0.083   2      0.197    0.280
1926.1      19968.0 21504.0  0.0    0.0   518656.0 53435.2   238080.0   19608.3   35416.0 33790.8 4736.0 4328.1      5    0.083   2      0.197    0.280
1927.2      19968.0 21504.0  0.0    0.0   518656.0 53435.2   238080.0   19608.3   35416.0 33790.8 4736.0 4328.1      5    0.083   2      0.197    0.280
1928.2      19968.0 21504.0  0.0    0.0   518656.0 53435.2   238080.0   19608.3   35416.0 33790.8 4736.0 4328.1      5    0.083   2      0.197    0.280

- gcutil GC 相关区域的使用率统计 百分比

λ jstat -gcutil -t 27308 1000 1000
Timestamp	S0(S0区)	S1(S1区)	E(Eden区)		O(老年代)	M(元数据区)	CCS(压缩class空间)	YGC(年轻代GC次数)	YGCT(年轻代GC总耗时)	FGC(FullGC次数)	FGCT(FullGC总耗时)	GCT(GC加起来总耗时,YGCT+FGCT)
1876.6		0.00		0.00		10.30			8.24		95.41		91.39				5					0.083					2				0.197				0.280
1877.6		0.00		0.00		10.30			8.24		95.41		91.39				5					0.083					2				0.197				0.280
1878.6		0.00		0.00		10.30			8.24		95.41		91.39				5					0.083					2				0.197				0.280
1879.6		0.00		0.00		10.30			8.24		95.41		91.39				5					0.083					2				0.197				0.280
``` 

- jmap 查看heap或类占用空间统计

    - -heap 打印堆内存的配置和使用信息
    ```shell
    λ jmap -heap 27308
    Attaching to process ID 27308, please wait...
    Debugger attached successfully.
    Server compiler detected.
    JVM version is 25.181-b13
    
    using thread-local object allocation.
    Parallel GC with 8 thread(s)
    
    Heap Configuration:
    MinHeapFreeRatio         = 0
    MaxHeapFreeRatio         = 100
    MaxHeapSize              = 8556380160 (8160.0MB)
    NewSize                  = 178257920 (170.0MB)
    MaxNewSize               = 2852126720 (2720.0MB)
    OldSize                  = 356515840 (340.0MB)
    NewRatio                 = 2
    SurvivorRatio            = 8
    MetaspaceSize            = 21807104 (20.796875MB)
    CompressedClassSpaceSize = 1073741824 (1024.0MB)
    MaxMetaspaceSize         = 17592186044415 MB
    G1HeapRegionSize         = 0 (0.0MB)
    
    Heap Usage:
    PS Young Generation
    Eden Space:
    capacity = 531103744 (506.5MB)
    used     = 54717640 (52.18280792236328MB)
    free     = 476386104 (454.3171920776367MB)
    10.302627427909828% used
    From Space:
    capacity = 22020096 (21.0MB)
    used     = 0 (0.0MB)
    free     = 22020096 (21.0MB)
    0.0% used
    To Space:
    capacity = 20447232 (19.5MB)
    used     = 0 (0.0MB)
    free     = 20447232 (19.5MB)
    0.0% used
    PS Old Generation
    capacity = 243793920 (232.5MB)
    used     = 20078904 (19.14873504638672MB)
    free     = 223715016 (213.35126495361328MB)
    8.236015073714718% used
    
    16567 interned Strings occupying 2168640 bytes.    
    ```


-histo 看哪些类占用的多

-dump:format=b,file=xxx.hprof Dump
```