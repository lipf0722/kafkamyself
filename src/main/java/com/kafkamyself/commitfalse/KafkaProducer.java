package com.kafkamyself.commitfalse;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.kafkamyself.util.TopicList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @GetMapping("teststart")
    public void start(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("key", DateUtil.now());
        ListenableFuture listenableFuture = kafkaTemplate.send(TopicList.TOPIC_ONE, JSONUtil.toJsonStr(jsonObject));
        //发送成功后回调
        SuccessCallback successCallback = new SuccessCallback() {
            @Override
            public void onSuccess(Object result) {
                System.out.println(DateUtil.now()+"--消息发送成功");
            }
        };
        //发送失败回调
        FailureCallback failureCallback = new FailureCallback() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("发送失败");
            }
        };
        listenableFuture.addCallback(successCallback,failureCallback);
    }
}
