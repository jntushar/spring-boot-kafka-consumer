package com.tushar.springbootkafkaconsumerexample.listener;

import com.tushar.springbootkafkaconsumerexample.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaConsumer {

    private static final String TOPIC = "Kafka_Demo";
    private static final String GROUP_ID_1 = "consumer_group_1";
    private static final String GROUP_ID_2 = "consumer_group_2";
    private static final String CONTAINER_FACTORY = "userKafkaListenerFactory";

    @KafkaListener(topics = TOPIC, groupId = GROUP_ID_1, containerFactory = CONTAINER_FACTORY)
    public void consumeUser1(@Payload List<User> users,
                             @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                             @Header(KafkaHeaders.OFFSET) List<Long> offsets){
        System.out.println(users.size());
        for(int i=0; i<users.size(); i++){
            System.out.println("consumer1, partition = " + partitions.get(i) +
                    ", offset = " + offsets.get(i) +
                    ", group_id = " + GROUP_ID_1 +
                    ", user = " + users.get(i));
        }
    }
//
//    @KafkaListener(topics = TOPIC, groupId = GROUP_ID_1, containerFactory = CONTAINER_FACTORY, topicPartitions = @TopicPartition(
//            topic = TOPIC, partitions = {"0"}
//    ))
//    public void consumeUser2(@Payload List<User> users,
//                             @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
//                             @Header(KafkaHeaders.OFFSET) List<Long> offsets){
//        System.out.println(users.size());
//        for(int i=0; i<users.size(); i++){
//            System.out.println("consumer2, partition = " + partitions.get(i) +
//                    ", offset = " + offsets.get(i) +
//                    ", group_id = " + GROUP_ID_1 +
//                    ", user = " + users.get(i));
//        }
//    }
}
