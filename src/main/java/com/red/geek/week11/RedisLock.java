package com.red.geek.week11;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Collections;

/**
 * RedisLock
 *
 * @author red
 * @class_name RedisLock
 * @date 2021-06-20
 */
public class RedisLock {

    public enum Singleton {
        INSTANCE;

        RedisLock redisLock;

        Singleton() {
            redisLock = new RedisLock();
        }

        public RedisLock getSingleton() {
            return redisLock;
        }
    }

    private JedisPool jedisPool = new JedisPool();

    public boolean lock(String lockValue, int seconds) {
        try(Jedis jedis = jedisPool.getResource()) {
            jedis.set(lockValue, lockValue);
            jedis.expire(lockValue, seconds);
            return true;
        }
    }

    public boolean release(String lock) {
        String luaScript = "if redis.call('get',KEYS[1]) == ARGV[1] then " + "return redis.call('del',KEYS[1]) else return 0 end";
        try(Jedis jedis = jedisPool.getResource()) {
            return jedis.eval(luaScript, Collections.singletonList(lock), Collections.singletonList(lock)).equals(1L);
        }
    }
}
