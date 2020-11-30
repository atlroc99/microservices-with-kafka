package com.mz.kafka.api.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OrderItemRequest {
    private String itemName;
    private int price;
    private int quantity;
}
