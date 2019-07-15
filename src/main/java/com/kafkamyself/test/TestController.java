package com.kafkamyself.test;

import com.kafkamyself.producer.KafkaSender;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    KafkaSender kafkaSender;

    @GetMapping("testSend")
    public String testSend(){
       return kafkaSender.send();



    }


}
