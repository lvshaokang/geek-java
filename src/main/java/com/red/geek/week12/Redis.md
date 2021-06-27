## Redis主从复制
```
port 6379
bind 192.168.11.202
requirepass "myredis"
daemonize yes
logfile "6379.log"
dbfilename "dump-6379.rdb"
dir "/opt/soft/redis/data"
```

## Redis Sentinel 哨兵
```
port 16381
daemonize no
pidfile /var/run/redis-sentinel.pid
logfile ""
dir /tmp
sentinel monitor mymaster 192.168.101.104 6381 2
sentinel down-after-milliseconds mymaster 10000
sentinel failover-timeout mymaster 30000
sentinel parallel-syncs mymaster 1
```