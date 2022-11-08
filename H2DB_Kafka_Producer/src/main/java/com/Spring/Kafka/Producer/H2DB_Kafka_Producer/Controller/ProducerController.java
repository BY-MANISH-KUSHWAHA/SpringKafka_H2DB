package com.Spring.Kafka.Producer.H2DB_Kafka_Producer.Controller;


import com.Spring.Kafka.Producer.H2DB_Kafka_Producer.Model.User;
import com.Spring.Kafka.Producer.H2DB_Kafka_Producer.Producer.TopicProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/kafka/producer")
public class ProducerController {
    private final TopicProducer topicProducer;

    @GetMapping("/send/{name}")
    public void send(@PathVariable("name") String name){
        topicProducer.send("Hello! "+name+".");
    }

    @PostMapping("/send")
    public User send(@RequestBody User user){
        topicProducer.send(user.toString());
        return user;

    }

}
