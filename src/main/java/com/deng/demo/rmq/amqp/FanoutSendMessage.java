package com.deng.demo.rmq.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FanoutSendMessage {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String msg){

        rabbitTemplate.convertAndSend("fanoutExchange","", msg);
    }
}
