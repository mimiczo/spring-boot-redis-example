package com.redis.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * com.redis.configuration.properties
 * Created by mimiczo on 2016.03.03
 */
@Component
@ConfigurationProperties(locations="classpath:application.yml", prefix="spring.redis")
@Data
public class RedisProperties {

    private String hostname;
    private int port;
}
