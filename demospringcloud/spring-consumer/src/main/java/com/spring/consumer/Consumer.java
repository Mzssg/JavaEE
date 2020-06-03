package com.spring.consumer;


import com.spring.consumer.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class Consumer {

    @Autowired
    private Client client;

    @RequestMapping("get")
    public String get(){
        System.out.println("第一次进入consumer的get方法");
        String produce = client.produce();
        System.out.println(produce);
        System.out.println("第二次进入consumer的get方法");
        return "成功";
    }
}
