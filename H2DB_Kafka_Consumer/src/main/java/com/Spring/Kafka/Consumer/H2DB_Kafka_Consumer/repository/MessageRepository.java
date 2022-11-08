package com.Spring.Kafka.Consumer.H2DB_Kafka_Consumer.repository;


import com.Spring.Kafka.Consumer.H2DB_Kafka_Consumer.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {

}
