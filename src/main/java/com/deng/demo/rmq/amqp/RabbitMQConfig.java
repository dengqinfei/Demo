package com.deng.demo.rmq.amqp;

/**
 *
 */

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.ConsumerTagStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author 醉逍遥
 *
 */
@Configuration
public class RabbitMQConfig{

    //    获取连接工厂
    @Bean
    public ConnectionFactory factory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setHost("10.19.131.13");
        factory.setPort(6004);
        factory.setUsername("qinfei");
        factory.setPassword("qinfei");
        factory.setVirtualHost("/test_host");
        return factory;
    }
    //    获取rabbitmqAdmin
    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory factory) {
        RabbitAdmin admin = new RabbitAdmin(factory);
        admin.setAutoStartup(true);
        return admin;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory factory) {
        RabbitTemplate template =new RabbitTemplate(factory);
        return template;
    }

    /**
     * 不配置这个容器，启动项目时候，rabbitmq的管控台看不到动作
     * @param factory
     * @return
     */
    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory factory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(factory);
        container.setConsumerTagStrategy(new ConsumerTagStrategy() {

            @Override
            public String createConsumerTag(String queue) {
                return null;
            }
        });
        return container;
    }



}
