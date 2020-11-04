package com.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: cgq
 * @Date: 2020/11/4 16:50
 */
@EnableBinding(Sink.class)
@Component
public class ReceiveMessageController {

    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者二号*******接受到消息" + message.getPayload() + "******" + port);
    }

}
