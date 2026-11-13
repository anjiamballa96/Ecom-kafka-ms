package com.jgak.orderservice.controller;


import com.jgak.basedomains.dto.Order;
import com.jgak.basedomains.dto.OrderEvent;
import com.jgak.orderservice.Kafka.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderController {

    private final OrderProducer orderProducer;

    @PostMapping("/placeorder")
    public String placeOrder(@RequestBody Order order) {

        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setOrder(order);
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("order status in pending state");

        orderProducer.sendMessage(orderEvent);

        return "Order placed successfully...";
    }
}
