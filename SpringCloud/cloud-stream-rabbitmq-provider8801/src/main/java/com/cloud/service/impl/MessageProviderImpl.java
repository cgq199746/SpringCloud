package com.cloud.service.impl;

import com.cloud.service.MessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;


/**
 * @Description: 消息发送者的生产管道
 * @Author: cgq
 * @Date: 2020/11/4 15:38
 */
@EnableBinding(Source.class)//定义消息的推送管道
public class MessageProviderImpl implements MessageProvider {

    @Resource
    private MessageChannel output;//消息发送通道

    @Override
    public String send() {
        String sendMessage = "hello";
        output.send(MessageBuilder.withPayload(sendMessage).build());
        System.out.println("sendMessage*********" + sendMessage);
        return null;
    }
}
