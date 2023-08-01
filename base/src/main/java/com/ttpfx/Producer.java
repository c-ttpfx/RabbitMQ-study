package com.ttpfx;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ttpfx
 * @since 2023/8/1
 */
public class Producer {

    private final static String QUEUE = "QUEUE";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.179.136");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("ttpfx");
        connectionFactory.setPassword("ttpfx");

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE,false,false,false,null);

        String message = "hello world";
        channel.basicPublish("",QUEUE,null,message.getBytes());
        System.out.println("消息发送完毕");
    }
}
