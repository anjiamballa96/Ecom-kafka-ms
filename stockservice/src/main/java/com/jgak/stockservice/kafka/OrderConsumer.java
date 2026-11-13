package com.jgak.stockservice.kafka;


import com.jgak.basedomains.dto.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent orderEvent) {
        log.info("Stock module -> Consumed Order Event: {}", orderEvent);
        //Can do rest operations
    }
}
