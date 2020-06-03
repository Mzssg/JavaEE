package com.spring.consumer.client;

import org.springframework.stereotype.Component;

@Component
public class ClientImpl implements Client{
    @Override
    public String produce() {
        return "1";
    }
}
