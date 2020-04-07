package com.example.multiplebinders.streams.rabbit;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Channels {

    @Input("rabbitQueueIn")
    SubscribableChannel rabbitQueueIn();

    @Output("kafkaTopicOut")
    MessageChannel kafkaTopicOut();
    
}