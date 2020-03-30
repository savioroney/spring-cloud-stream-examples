package com.example.binderrabbit.streams;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Channels {

    @Input("topicInput")
    SubscribableChannel topicInput();

}