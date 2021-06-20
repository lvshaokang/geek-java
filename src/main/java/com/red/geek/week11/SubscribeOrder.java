package com.red.geek.week11;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

/**
 * SubscribeOrder
 *
 * @author red
 * @class_name SubscribeOrder
 * @date 2021-06-20
 */
public class SubscribeOrder {
    public SubscribeOrder(final JedisPool jedisPool, final String channelName) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try(Jedis jedis = jedisPool.getResource()) {
                    jedis.subscribe(setupSubscriber(), channelName);
                }
            }
        }, "subscriberThread").start();
    }

    private JedisPubSub setupSubscriber() {
        return new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                if (message.isEmpty()) {
                    System.exit(0);
                }
                System.out.printf("Receive message from %s :: %s\n", channel, message);
            }
        };
    }
}
