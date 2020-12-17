package com.example.SpringBootActiveMQConsumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
    @JmsListener(destination = "demo")
    public void reveiveMessage(String message) {
        System.out.println(message);
    }
}
