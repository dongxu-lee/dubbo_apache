package com.ldx.bean;

import com.ldx.service.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class ConsumerComponet {
    @Reference
    private HelloService helloService;
    public String sayHello(String name) {
        return helloService.sayHello(name);
    }

}
