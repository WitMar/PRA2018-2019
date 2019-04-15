package com.microserviceredis.microserviceredis;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:WEB-INF/event-queue-config.xml")
@AutoConfigureAfter(RedisConfig.class)
@Configuration
public class SpringIntegrationConfig {
}
