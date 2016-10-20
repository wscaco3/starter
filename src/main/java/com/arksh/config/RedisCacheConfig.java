package com.arksh.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.*;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;
import java.util.stream.Stream;

@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {


	@Bean
	public CacheManager cacheManager(RedisTemplate redisTemplate) {
		return new RedisCacheManager(redisTemplate);
	}

	@Bean
	public RedisTemplate<Serializable, Serializable> redisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<Serializable, Serializable> template = new RedisTemplate<Serializable, Serializable>();
		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
		GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
		template.setConnectionFactory(factory);
		template.setKeySerializer(stringRedisSerializer);
		template.setValueSerializer(genericJackson2JsonRedisSerializer);
		template.setHashKeySerializer(stringRedisSerializer);
		template.setHashValueSerializer(genericJackson2JsonRedisSerializer);
		return template;
	}

    @Bean
    public KeyGenerator keyGenerator() {
        return (target, method, params)->{
            StringBuilder sb = new StringBuilder(Constants.CACHE_NAMESPACE);
            sb.append(target.getClass().getSimpleName());
            Stream.of(params).forEach(sb.append("_")::append);
            return sb.toString();
        };
    }
}
