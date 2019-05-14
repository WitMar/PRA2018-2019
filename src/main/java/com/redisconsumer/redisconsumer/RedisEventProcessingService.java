package com.redisconsumer.redisconsumer;

import org.springframework.stereotype.Service;

@Service("RedisEventProcessingService")
public class RedisEventProcessingService implements EventProcessingService {

    @Override
    public void process(PostPublishedEvent event) {
       System.out.println(event.getEmails() + " " + event.getPostTitle() + " " + event.getPostUrl());
    }

}
