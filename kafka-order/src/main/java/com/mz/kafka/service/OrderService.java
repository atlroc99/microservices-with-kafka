package com.mz.kafka.service;

import com.mz.kafka.broker.message.KafkaOrderMessagePublisher;
import com.mz.kafka.dto.OrderDto;
import com.mz.kafka.dto.OrderItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private KafkaOrderMessagePublisher publisher;

    public void createOrder() {
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
