package com.youngboyandnunas.backend.global.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

@RequiredArgsConstructor
@Configuration
public class EmbeddedRedisConfig {

    private static RedisServer redisServer;

    @Value("${spring.redis.port}")
    private Integer port;

    @PostConstruct
    public void runRedis() throws IOException {
        if(redisServer == null) {
            redisServer = new RedisServer(port);
            redisServer.start();
        }
    }

    @PreDestroy
    public void stopRedis() {
        if(redisServer != null) {
            redisServer.stop();
        }
    }

}
