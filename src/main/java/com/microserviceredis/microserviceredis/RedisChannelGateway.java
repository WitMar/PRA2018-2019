package com.microserviceredis.microserviceredis;


public interface RedisChannelGateway {

    void enqueue(PostPublishedEvent event);

}
