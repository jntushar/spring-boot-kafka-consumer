package com.tushar.springbootkafkaconsumerexample.listener;

import com.tushar.springbootkafkaconsumerexample.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeListener {

    private static final String EMPLOYEE_TOPIC = "employee-topic";
    private static final String GROUP_ID_1 = "consumer_group_1";
    private static final String CONTAINER_FACTORY = "employeeKafkaListenerFactory";

    @KafkaListener(topics = EMPLOYEE_TOPIC, containerFactory = CONTAINER_FACTORY)
    public void consumerEmployee(List<ConsumerRecord<String, Employee>> records){
        for (ConsumerRecord<String, Employee> record: records){
            log.info("Topic = {} | Partition={} | Offset={} | Employee={}",
                    record.topic(), record.partition(), record.offset(), record.value());
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
