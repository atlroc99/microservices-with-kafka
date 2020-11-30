package com.mz.kafka.command.service;

import com.mz.kafka.broker.message.KafkaOrderMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private KafkaOrderMessagePublisher publisher;

/*    public void createOrder() {
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
    }*/

    public String saveOrder() {
        return "";
    }
}
