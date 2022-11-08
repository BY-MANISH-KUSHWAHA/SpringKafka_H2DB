package com.Spring.Kafka.Producer.H2DB_Kafka_Producer.Producer;

import com.Spring.Kafka.Producer.H2DB_Kafka_Producer.Model.Message;
import com.Spring.Kafka.Producer.H2DB_Kafka_Producer.Repository.MessageRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j // setter/getter/constructor/table
@RequiredArgsConstructor
@Service
public class TopicProducer {
    @Value("${topic.name.producer}")
    private String topicName;


    @Autowired
    private MessageRepository repository;

    private final KafkaTemplate<String,String> kafkaTemplate;

    public Message send(String message){

        kafkaTemplate.send(topicName,message);
        return repository.save(Message.extractFromString(message));

    }
}
