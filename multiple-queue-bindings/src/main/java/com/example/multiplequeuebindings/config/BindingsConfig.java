package com.example.multiplequeuebindings.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.amqp.core.BindingBuilder.bind;

@Configuration
public class BindingsConfig {

    private RabbitAdmin rabbitAdmin;

    public BindingsConfig(RabbitTemplate rabbitTemplate) {
        this.rabbitAdmin = new RabbitAdmin(rabbitTemplate);
    }

    @Bean
    public void enableQueueBindings() {
        Queue queue = new Queue("queue1");
        TopicExchange exchange = new TopicExchange("example-exchange");
        rabbitAdmin.declareQueue(queue);

        Binding bindingRoutingKeyCreate = bind(queue).to(exchange).with("routingKeyCreate");
        rabbitAdmin.declareBinding(bindingRoutingKeyCreate);

        Binding bindingRoutingKeyDelete = bind(queue).to(exchange).with("routingKeyDelete");
        rabbitAdmin.declareBinding(bindingRoutingKeyDelete);
    }
}
