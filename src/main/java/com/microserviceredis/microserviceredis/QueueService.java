package com.microserviceredis.microserviceredis;

public interface QueueService {

    void enqueue(PostPublishedEvent event);
}
