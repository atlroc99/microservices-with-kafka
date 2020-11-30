package com.mz.kafka.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mz.kafka.util.LocalDateTimeDeserializer;
import com.mz.kafka.util.LocalDateTimeSerializer;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OrderRequest {
    private String orderNumber;
    private String orderLocation;
    private List<OrderItemRequest> orderItemDtos;

    @JsonProperty("order-creation-date")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime orderCreateDate;
}
