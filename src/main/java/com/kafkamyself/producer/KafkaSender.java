package com.kafkamyself.producer;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.kafkamyself.util.TopicList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    //发送消息方法
    public String send() {
        String str="";
      try {
          for (int i = 0; i <500 ; i++) {
              JSONObject jsonObject=new JSONObject();
              jsonObject.put("key", UUID.randomUUID().toString().replaceAll("-",""));
              jsonObject.put("time", DateUtil.now());
              System.out.println(DateUtil.now()+"--生产消息"+JSONUtil.toJsonStr(jsonObject));
              kafkaTemplate.send(TopicList.TOPIC_ONE,JSONUtil.toJsonStr(jsonObject));
              str="cg！";
          }
      }catch (Exception e){
          e.printStackTrace();
          str="失败!";
      }
      return  str;
    }
}
