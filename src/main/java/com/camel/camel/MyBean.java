package com.camel.camel;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component("myBean")
public class MyBean {

    public String saySomething() {
        return "Hi";
    }

}
