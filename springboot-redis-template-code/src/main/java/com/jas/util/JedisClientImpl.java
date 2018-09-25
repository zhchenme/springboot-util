package com.jas.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * <p>
 * Redis 工具类接口实现
 * </p>
 * 
 * @author zchen
 * @create 2018-09-25 15:41
 */
@Component
public class JedisClientImpl implements JedisClient {
    @Autowired
    private JedisPool jedisPool;
    
    @Override
    public String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        String result;
        
        try {
            result = jedis.set(key, value);
        } finally {
            jedis.close();
        }

        return result;
    }

    @Override
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String result;
        
        try {
            result = jedis.get(key);
        } finally {
            jedis.close();
        }

        return result;
    }

    @Override
    public Boolean exists(String key) {
        Jedis jedis = jedisPool.getResource();
        Boolean result;
        
        try {
            result = jedis.exists(key);
        } finally {
            jedis.close();
        }

        return result;
    }

    @Override
    public Long incr(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result;
        
        try {
            result = jedis.incr(key);
        } finally {
            jedis.close();
        }

        return result;
    }
}
