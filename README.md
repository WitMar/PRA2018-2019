# microserviceredis
microservice with redis

Jedis is a Redis client.
The Spring Data Redis dependency makes it easier to use Redis in Java. It provides familiar Spring concepts such as a template class for core API usage and lightweight repository-style data access.
Spring Integration Redis provides an extension of the Spring programming model to support the well-known.

utilisation also de lombok for making the code much more short with @Getter,@Setter,@Builder(for instancian the constructor)

jedis client is configured in RedisConfig class

message to send the queue is defined PostPublishedEvent

event-queue-config.xml= define the queue itself.

RedisChannelGateway=define the gateway which is mentioned in the xml file

SpringIntegrationConfig=import it for wiring the configuration

QueueService RedisQueueService =  implement the method that will enqueue events to the Redis queue.


event-queue-config2.xml = create the queue config

EventProcessingService and RedisEventProcessingService = service which will actually process the event.
