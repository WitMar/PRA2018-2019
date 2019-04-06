package repository;


import model.PostPublishedEvent;

public interface RedisChannelGateway {

    void enqueue(PostPublishedEvent event);


}
