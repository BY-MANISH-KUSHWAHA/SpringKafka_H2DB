package com.Spring.Kafka.Consumer.H2DB_Kafka_Consumer.Consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j // setter/getter/constructor/table
@RequiredArgsConstructor
@Service
public class TopicConsumer {
    @Value("${topic.name.consumer}")
    private String topicName;

    private String latestConsumeData;

    @KafkaListener(topics = "${topic.name.consumer}",groupId = "group_id_consumer")
    public String consume(ConsumerRecord<String,String> payload){
        System.out.println(payload);
        log.info("Topic Name:"+topicName);
        log.info("Key:"+payload.key());
        log.info("Value:"+payload.value());
        log.info("Header:"+payload.headers());
        log.info("Partition:"+payload.partition());
        latestConsumeData = payload.value();
        return payload.value();
    }

    public String getLoadedConsume() {
        return latestConsumeData;
    }
}
