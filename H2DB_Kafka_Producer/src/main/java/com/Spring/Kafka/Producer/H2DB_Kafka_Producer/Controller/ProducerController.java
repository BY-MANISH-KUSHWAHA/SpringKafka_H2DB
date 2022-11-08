package com.Spring.Kafka.Producer.H2DB_Kafka_Producer.Controller;


import com.Spring.Kafka.Producer.H2DB_Kafka_Producer.Model.Message;
import com.Spring.Kafka.Producer.H2DB_Kafka_Producer.Producer.TopicProducer;
import com.Spring.Kafka.Producer.H2DB_Kafka_Producer.Repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/kafka/producer")
public class ProducerController {
    private final TopicProducer topicProducer;

    @Autowired
    private MessageRepository repository;

    @GetMapping("/send/{name}")
    public void send(@PathVariable("name") String name){
        topicProducer.send("Hello! "+name+".");
    }

    @PostMapping("/send")
    public Message send(@RequestBody Message message){
        return topicProducer.send(message.toString());

    }

    @GetMapping("/getAllMessage")
    public List<Message> getAllMessage(){
        return repository.findAll();
    }

}
