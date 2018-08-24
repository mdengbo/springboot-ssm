package com.example.ssmdemo.cache;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author madengbo
 * @create 2018-08-24 17:42
 * @desc
 * @Version 1.0
 **/
public class JedisPoolWriper {
    private JedisPool jedisPool;

    public JedisPoolWriper(final JedisPoolConfig poolConfig, final String host,
                           final int port) {
        try {
            jedisPool = new JedisPool(poolConfig, host, port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }
}
