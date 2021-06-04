package com.deng.demo;

import com.deng.demo.rmq.amqp.FanoutSendMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqSpringbootApplicationTests {

    @Autowired
    FanoutSendMessage fanoutSend;

    @Test
    public void rmqSend() {
        fanoutSend.send("测试fanout发送。。。");
    }
}

