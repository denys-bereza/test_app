package com.denys_bereza.test_app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
class AppConfig {
    @Value("${redis.hostName}")
    private String redisHostName;

    @Value("${redis.port}")
    private int redisPort;

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(this.redisHostName, this.redisPort);
        return new JedisConnectionFactory(config);
    }
}
