package com.mz.kafka.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean(name = "orderTopic")
    public NewTopic topicOrder() {
        return TopicBuilder.name("t_order").partitions(2).replicas(1).build();
    }
}
