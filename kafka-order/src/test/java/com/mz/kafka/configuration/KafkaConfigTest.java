package com.mz.kafka.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class KafkaConfigTest {

    Logger logger = LoggerFactory.getLogger(KafkaConfig.class);

    @Autowired
    KafkaConfig config;

    @Test
    void topicOrder() {
        NewTopic orderTopic = config.topicOrder();
        assertNotNull(orderTopic);
        logger.info("topic name: {}", orderTopic.name());
        logger.info("Replication factor: {}", orderTopic.replicationFactor());
        logger.info("Num of Paritions: {}", orderTopic.numPartitions());
        assertEquals(orderTopic.name(), "t_order");

    }
}