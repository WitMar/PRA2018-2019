package com.redisconsumer.redisconsumer;

import org.springframework.stereotype.Service;

@Service("RedisEventProcessingService")
public class RedisEventProcessingService implements EventProcessingService {

    @Override
    public void process(PostPublishedEvent event) {
        // TODO: Send emails here, retry strategy, etc :)
    }

}
