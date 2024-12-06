package com.beien.service;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(consumerGroup = "beien-rocketmq-test",topic = "beien-rocketmq-test")
public class RocketMQConsumerListener implements RocketMQListener<String> {
    /**
     * 生成者发送的消息 message
     * @param message
     */
    @Override
    public void onMessage(String message) {
        //代码演示 构造方法 具体开发采用服务+监听器方式开发业务功能
        System.out.println("消费消息："+message);
    }
}