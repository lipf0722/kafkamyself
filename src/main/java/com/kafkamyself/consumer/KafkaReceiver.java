package com.kafkamyself.consumer;

import cn.hutool.core.date.DateUtil;
import com.kafkamyself.util.TopicList;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class KafkaReceiver {
   //自动提交
   /* @Value("${spring.kafka.consumer.group-id}")
    private String group;

    @KafkaListener(topics = {TopicList.TOPIC_ONE})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.out.println("分区-----"+record.partition()+"----"+group+"----"+DateUtil.now()+"---消费者------------------ message =" + message);
        }

    }*/
}
