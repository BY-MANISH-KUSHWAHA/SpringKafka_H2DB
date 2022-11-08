package com.Spring.Kafka.Consumer.H2DB_Kafka_Consumer.Controller;

import com.Spring.Kafka.Consumer.H2DB_Kafka_Consumer.Consumer.TopicConsumer;
import com.Spring.Kafka.Consumer.H2DB_Kafka_Consumer.Model.Message;
import com.Spring.Kafka.Consumer.H2DB_Kafka_Consumer.repository.MessageRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kafka/consumer")
public class ConsumerController {

    private final TopicConsumer consumer;

    @Autowired
    private final MessageRepository repository;

    @GetMapping("/consume")
    public Message consume(){
        return consumer.getLoadedConsume();
    }

    @GetMapping("/getAllMessage")
    public List<Message> getAllMessage(){
        return repository.findAll();
    }

}
