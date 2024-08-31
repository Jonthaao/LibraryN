package com.library.order.Configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

    private String orderCreated = "order-created";
    private String orderAccepted = "order-accepted";
    private String orderRejected = "order-rejected";

    @Bean
    public NewTopic createOrderCreatedTopic() {

        return TopicBuilder.name(orderCreated).partitions(1).replicas(1).build();
    }

    @Bean
    public NewTopic createOrderAcceptedTopic() {

        return TopicBuilder.name(orderAccepted).partitions(1).replicas(1).build();
    }

    @Bean
    public NewTopic createOrderRejectedTopic() {

        return TopicBuilder.name(orderRejected).partitions(1).replicas(1).build();
    }
}
