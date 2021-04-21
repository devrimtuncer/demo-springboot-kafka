package com.example.kafka_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@RestController
public class SampleController {

    private final KafkaProducerService kafkaProducerService;

    public SampleController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    /**
     * Sends 10000 messages to topic
     *
     * @return
     */
    @GetMapping("/")
    public String send() {
        IntStream.range(0, 10000).parallel().forEach(
                i -> {
                    Person person = new Person(String.format("Person %s", i), i);
                    kafkaProducerService.send(person);
                }
        );
        return "Hello Kafka";
    }

}
