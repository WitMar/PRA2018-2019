package service;

import model.PostPublishedEvent;
import org.springframework.stereotype.Service;
import repository.EventProcessingService;

@Service("RedisEventProcessingService")
public class RedisEventProcessingService implements EventProcessingService {

    @Override
    public void process(PostPublishedEvent event) {
        // TODO: Send emails here, retry strategy, etc :)
    }

}