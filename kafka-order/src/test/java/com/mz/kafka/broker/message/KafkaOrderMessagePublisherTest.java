package com.mz.kafka.broker.message;

import com.mz.kafka.dto.OrderDto;
import com.mz.kafka.dto.OrderItemDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class KafkaOrderMessagePublisherTest {

    @Autowired
    private KafkaOrderMessagePublisher publisher;

    @Test
    void sendMessage() {

        List<OrderItemDto> itemDtos = Arrays.asList(
                OrderItemDto.builder().itemName("Avis Rent-a-car").price(399).quantity(1).build()
        );

        OrderDto orderDto = OrderDto.builder()
                .orderItemDtos(itemDtos)
                .orderLocation("Lilburn")
                .orderNumber(UUID.randomUUID().toString())
                .orderCreateDate(LocalDateTime.now(ZoneId.systemDefault()))
                .build();

        publisher.sendMessage(orderDto);
    }
}