package com.deng.demo.rmq.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
//@RabbitListener(queues = "fanout.a")
public class FanoutCustomer {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RabbitHandler
    public void process(String message) {
        log.info("接收消息:{}", message);
    }
}

