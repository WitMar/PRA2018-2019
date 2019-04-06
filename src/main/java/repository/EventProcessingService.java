package repository;

import model.PostPublishedEvent;
import org.springframework.stereotype.Service;

public interface EventProcessingService {

    void process(PostPublishedEvent event);
}

