package com.microserviceredis.microserviceredis;

public interface EventProcessingService {

    void process(PostPublishedEvent event);
}

