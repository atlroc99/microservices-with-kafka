package com.mz.kafka.broker.message;

import com.mz.kafka.dto.OrderDto;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Configuration
public class KafkaOrderMessagePublisher {

    Logger logger = LoggerFactory.getLogger(KafkaOrderMessagePublisher.class);

    @Autowired
    KafkaTemplate<String, OrderDto> kafkaTemplate;

    public void sendMessage(OrderDto orderDto) {
        logger.info("Send OrderDto message {}", orderDto);
        kafkaTemplate.send("t_order", orderDto).addCallback(new ListenableFutureCallback<SendResult<String, OrderDto>>() {
            @Override
            public void onFailure(Throwable ex) {
                logger.error("Message sent failed: to topic t_order; because {} ", ex.getMessage(), ex);
            }

            @Override
            public void onSuccess(SendResult<String, OrderDto> result) {
                ProducerRecord<String, OrderDto> producerRecord = result.getProducerRecord();
                logger.info("Success!! Send message to topic {}", producerRecord.topic());
                logger.info("order: {}", producerRecord.value());
            }
        });


    }


}
