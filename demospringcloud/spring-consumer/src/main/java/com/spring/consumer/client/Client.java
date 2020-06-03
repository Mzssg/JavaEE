package com.spring.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(name = "producer", fallback = ClientImpl.class)
public interface Client {

    @RequestMapping("/producer/produce")
    public String produce();
}
