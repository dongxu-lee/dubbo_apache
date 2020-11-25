package com.ldx;

import com.ldx.bean.ConsumerComponet;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

public class ConsumerApplication {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        // 获取消费者组件
        ConsumerComponet service = context.getBean(ConsumerComponet.class);
        while (true) {
            System.in.read();
            String hello = service.sayHello("world");
            System.out.println("result:" + hello);
        }
    }

    @Configuration
    @PropertySource("classpath:/dubbo-consumer.properties")
    @ComponentScan(basePackages = "com.ldx.bean")
    @EnableDubbo
    static class ConsumerConfiguration {

    }
}
