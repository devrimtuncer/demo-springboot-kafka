package com.example.kafka_demo;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final String topicName = "my-topic";

    private final KafkaTemplate<String, Person> kafkaTemplate;

    KafkaProducerService(KafkaTemplate<String, Person> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Person person) {
        kafkaTemplate.send(topicName, person);
    }
}
