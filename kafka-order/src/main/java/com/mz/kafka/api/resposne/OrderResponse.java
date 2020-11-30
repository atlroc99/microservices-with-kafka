package com.mz.kafka.api.resposne;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OrderResponse {
    private String orderNumber;
}
