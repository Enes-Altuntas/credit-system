package org.colendi.infrastructure.config.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedissonConfig {

  @Value("${spring.data.redis.host}")
  private String redissonHost;
  @Value("${spring.data.redis.port}")
  private int redissonPort;

  @Bean
  public RedissonClient redissionClient() {
    Config config = new Config();
    config.useSingleServer().setAddress("redis://" + redissonHost + ":" + redissonPort);
    return Redisson.create(config);

  }
}
