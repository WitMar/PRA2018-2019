package com.microserviceredis.microserviceredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisQueueService implements QueueService {

    private RedisChannelGateway channelGateway;

    @Autowired
    public RedisQueueService(RedisChannelGateway channelGateway) {
        this.channelGateway = channelGateway;
    }

    @Override
    public void enqueue(PostPublishedEvent event) {
        channelGateway.enqueue(event);
    }
}
