package com.jas.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * <p>
 * Redis 配置类
 * </p>
 * 
 * @author zchen
 * @create 2018-09-25 16:12
 */
@Configuration
public class RedisConfig {
    @Value("${spring.redis.host}")
    private String host;
    
    @Value("${spring.redis.port}")
    private int port;
    
    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.timeout}")
    private int timeout;
    
    @Value("${spring.redis.pool.max-active}")
    private int maxActive;
    
    @Value("${spring.redis.pool.max-idle}")
    private int maxIdle;
    
    @Value("${spring.redis.pool.max-wait}")
    private long maxWaitMillis;

    @Bean
    public JedisPool jedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大空闲
        jedisPoolConfig.setMaxIdle(maxIdle);
        // 最大等待
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        // 获取连接时检查
        jedisPoolConfig.setTestOnBorrow(true);
        // 回归连接时检查
        jedisPoolConfig.setTestOnReturn(true);
        // 最大连接
        jedisPoolConfig.setMaxTotal(maxActive);

        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout);

        return jedisPool;
    }
}
