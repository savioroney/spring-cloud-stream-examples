package com.example.multiplebinders.streams.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Channels {
    
    @Input("kafkaTopicIn")
    SubscribableChannel kafkaTopicIn();
}