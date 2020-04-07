package com.example.multiplebinders.streams.kafka;

import com.example.multiplebinders.MultipleBindersApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

@EnableBinding({Channels.class})
public class ConsumerKafka {

    private final Logger logger = LoggerFactory.getLogger(MultipleBindersApplication.class);

    @StreamListener("kafkaTopicIn")
    public void consume(Message<String> message) {
        logger.info("Topic Output: " + message);
    }
}