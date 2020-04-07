package com.example.multiplebinders.streams.rabbit;

import com.example.multiplebinders.MultipleBindersApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

@EnableBinding({Channels.class})
public class ConsumerRabbit {

    private final Logger logger = LoggerFactory.getLogger(MultipleBindersApplication.class);

    @Autowired
    private MessageChannel kafkaTopicOut;

    @StreamListener("rabbitQueueIn")
    public void consume(Message<String> message) {
        logger.info("Queue Input: " + message);
        kafkaTopicOut.send(message);
    }
}