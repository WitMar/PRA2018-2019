package com.microserviceredis.microserviceredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class App {

    @Autowired
    RedisQueueService queue;

}


