package com.microserviceredis.microserviceredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
@ComponentScan
public class MicroserviceredisApplication {

	public static void main(String[] args) {

		SpringApplication.run(MicroserviceredisApplication.class, args);

		ApplicationContext ctx =
				new AnnotationConfigApplicationContext(SpringIntegrationConfig.class);
		System.out.println("ctx>>"+ctx);


		RedisChannelGateway myDemo= (RedisChannelGateway)ctx.getBean("eventChannelGateway");
		PostPublishedEvent post = new PostPublishedEvent("a","b",null);

		myDemo.enqueue(post);
	}

}
