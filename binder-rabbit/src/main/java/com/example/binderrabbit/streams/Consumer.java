package com.example.binderrabbit.streams;

import com.example.binderrabbit.BinderRabbitApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

@EnableBinding({Channels.class})
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(BinderRabbitApplication.class);

    @StreamListener("topicInput")
    public void consume(Message<String> message) {
        logger.info("Topic Input: " + message);
    }
}