package com.kafkamyself.commitfalse;

import com.kafkamyself.util.TopicList;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class KafkaConsumer {

    //containerFactory= "kafkaListenerContainerFactory"    KafkaConsumerConfig中仓库得方法名
    @KafkaListener(topics = {TopicList.TOPIC_ONE},containerFactory = "kafkaListenerContainerFactory")
    public void consumerMsg(List<ConsumerRecord> records , Acknowledgment ack){
        try {
            for (ConsumerRecord record : records) {
                System.out.println(String.format("消费到消息-----offset = %d, key = %s, value = %s%n \n", record.offset(), record.key(), record.value()));
            }
            ack.acknowledge();//手动提交偏移量
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
