package com.red.geek.week11;

import redis.clients.jedis.JedisPool;

/**
 * SubscribeApp
 *
 * @author red
 * @class_name SubscribeApp
 * @date 2021-06-20
 */
public class SubscribeApp {

    public static void main(String[] args) {
        JedisPool jedisPool = new JedisPool();
        String channelName = "ORDER";

        SubscribeOrder subscribeOrder = new SubscribeOrder(jedisPool, channelName);
        PublishOrder publishOrder = new PublishOrder(jedisPool, channelName);
    }
}
