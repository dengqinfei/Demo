package com.hikvision.demo;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQSend {
    private static final String EXCHANGE_NAME = "LuaExchange";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("10.33.40.15");
        factory.setUsername("root");
        factory.setPassword("JYuvkf3h");
        factory.setPort(6005);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
        String message = getMessage(argv);
        channel.basicPublish(EXCHANGE_NAME,"", null, message.getBytes("UTF-8"));
        System.out.println(" [x] Sent '" + message + "'");
        channel.close();
        connection.close();
    }

    private static String getMessage(String[] strings) {
        if (strings.length < 1)
            return "XXX YYYY!";
        return joinStrings(strings, " ");
    }

    private static String joinStrings(String[] strings, String delimiter) {
        int length = strings.length;
        if (length == 0)
            return "";
        StringBuilder words = new StringBuilder(strings[0]);
        for (int i = 1; i < length; i++) {
            words.append(delimiter).append(strings[i]);
        }
        return words.toString();
    }
}