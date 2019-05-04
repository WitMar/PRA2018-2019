package com.redisconsumer.redisconsumer;

public interface EventProcessingService {

    void process(PostPublishedEvent event);
}
