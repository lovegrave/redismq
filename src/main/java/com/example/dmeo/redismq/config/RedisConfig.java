package com.example.dmeo.redismq.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @decription RedisConfig
 * <p>redis连接池配置</p>
 * @author Yampery
 * @date 2018/2/9 12:54
 */
@Configuration
public class RedisConfig {

    @Bean(name = "jedisPool")
    @Primary
    public JedisPool getJedisPool() {
        return new JedisPool(jedisPoolConfig(), host, port, timeout);
    }

    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setNumTestsPerEvictionRun(maxTotal);
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(5000);
        jedisPoolConfig.setMinEvictableIdleTimeMillis(10000);
        jedisPoolConfig.setSoftMinEvictableIdleTimeMillis(10000);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        jedisPoolConfig.setTestWhileIdle(true);
        jedisPoolConfig.setTestOnReturn(testOnReturn);
        jedisPoolConfig.setJmxEnabled(true);
        jedisPoolConfig.setJmxNamePrefix("");
        jedisPoolConfig.setBlockWhenExhausted(false);

        return jedisPoolConfig;
    }


    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.jedis.timeout}")
    private int timeout;

    @Value("${spring.redis.jedis.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.jedis.max-wait}")
    private long maxWaitMillis;

    @Value("${spring.redis.jedis.max-active}")
    private int maxTotal;

    @Value("${redis.pool.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${redis.pool.testOnReturn}")
    private boolean testOnReturn;
}
