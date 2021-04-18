package com.example.kafka_demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class KafkaConsumerService {
    private final AtomicInteger consumedMessageCount = new AtomicInteger();

    private final String topicName = "my-topic";

    @KafkaListener(topics = topicName)
    public void listen(Person message) {
        System.out.printf("Received Message: %s, consumedMessageCount: %s%n", message, consumedMessageCount.incrementAndGet());
    }
}
