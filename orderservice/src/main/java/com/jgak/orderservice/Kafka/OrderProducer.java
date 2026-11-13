package com.jgak.orderservice.Kafka;

import com.jgak.basedomains.dto.OrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderProducer {

    @Autowired
    private NewTopic topic;

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public void sendMessage(OrderEvent orderEvent) {
        log.info("Order module -> Sending Order Event: {}", orderEvent);
        kafkaTemplate.send(topic.name(), orderEvent);
    }
}
