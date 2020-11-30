package com.mz.kafka.api;

import com.mz.kafka.api.request.OrderRequest;
import com.mz.kafka.api.resposne.OrderResponse;
import com.mz.kafka.command.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderApi {

    @Autowired
    OrderService orderService;

    @PostMapping(value = "/new-order", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderResponse> createNewOrder(@RequestBody OrderRequest orderRequest) {
        // 1. use service to save order
        String orderNumber = orderService.saveOrder();
        // 2.construct an order response -> we create a new instance of OrderResponse class by passing the orderNumber
        OrderResponse orderResponse = OrderResponse.builder().orderNumber(orderNumber).build();
        //3. resturn the OrderResponse as ResponseEntity body
        return ResponseEntity.ok().body(orderResponse);
    }
}
