package com.spring.producer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class Producer {

    @RequestMapping("produce")
    public String produce(){
        String res = "该程序经过了produce模块";
        return res;
    }

}
