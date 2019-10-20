package com.camel.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
public class CamelApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamelApplication.class, args);

	}

	@Component
	class StudentRoute extends RouteBuilder {

		@Override
		public void configure() {
			restConfiguration()
					.component("servlet")
					.port(8090)
					.bindingMode(RestBindingMode.json);

			rest("/student").produces("application/json")
					.get("/hello/{name}")
					.route().transform().simple("Hello ${header.name}, Welcome to JavaCamel")
					.endRest()
					.get("/records/{name}").to("direct:records")
					.get("/records").to("direct:abc")
					.get("/transform").route().transform().method("myBean", "saySomething").endRest();

			from("direct:records")
					.process(new Processor() {

						final AtomicLong counter = new AtomicLong();

						@Override
						public void process(Exchange exchange) throws Exception {

							final String name = exchange.getIn().getHeader("name",String.class);
							exchange.getIn().setBody(new Student(counter.incrementAndGet(),name,"Camel + SpringBoot"));
						}
					});

			from("direct:abc")
					.process(new Processor() {

						@Override
						public void process(Exchange exchange) throws Exception {

							exchange.getIn().setHeader("name", new String("Empty"));

						}
					})
					.to("direct:records");
		}

	}
    @Bean
    ServletRegistrationBean servletRegistrationBean() {
        final ServletRegistrationBean servlet = new ServletRegistrationBean(
                new CamelHttpTransportServlet(),"/camel/*");
        servlet.setName("CamelServlet");
        return servlet;
    }


}
