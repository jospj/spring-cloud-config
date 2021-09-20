package com.example.springcloud.app.counterservice;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RefreshScope
public class CounterController {

    private AtomicLong count = new AtomicLong(0L);

    @Value(value = "${counter.message.prefix}")
    private String prefixMessage;

    @GetMapping(path = "/count")
    public String getCount(){
        return prefixMessage + count.getAndIncrement();
    }
}
