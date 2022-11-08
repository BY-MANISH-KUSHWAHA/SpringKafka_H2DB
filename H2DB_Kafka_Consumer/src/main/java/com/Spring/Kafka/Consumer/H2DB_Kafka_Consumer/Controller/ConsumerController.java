package com.Spring.Kafka.Consumer.H2DB_Kafka_Consumer.Controller;

import com.Spring.Kafka.Consumer.H2DB_Kafka_Consumer.Consumer.TopicConsumer;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kafka/consumer")
public class ConsumerController {

    private final TopicConsumer consumer;

    @GetMapping("/consume")
    public String consume(){
        return consumer.getLoadedConsume();
    }
}
