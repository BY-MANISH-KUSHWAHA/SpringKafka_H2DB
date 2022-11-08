package com.Spring.Kafka.Producer.H2DB_Kafka_Producer.Repository;


import com.Spring.Kafka.Producer.H2DB_Kafka_Producer.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {

}
