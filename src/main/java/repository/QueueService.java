package repository;

import model.PostPublishedEvent;

public interface QueueService {

    void enqueue(PostPublishedEvent event);
}
