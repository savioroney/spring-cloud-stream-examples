package com.example.binderrabbit.streams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Producer {

    @Autowired
    private MessageChannel topicInput;

    @GetMapping(path = "/send/{foo}")
    public String sendFoo(@PathVariable String foo) {
        this.topicInput.send(MessageBuilder.withPayload(foo).build());
        
        return "Sent to queue1:" + foo;
    }

}