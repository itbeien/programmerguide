package com.beien.service.product;

import com.beien.enums.RocketEnum;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.stereotype.Component;

/**
 * @author beien
 * @date 2023/3/5 16:08
 * Copyright© 2023 beien
 * 消费者服务类，对延时消息进行业务处理
 */
@Component
public class BeienProducer {
    private String producerGroup = "beien-rocketmq-test";
    private DefaultMQProducer producer;
    //构造
    public BeienProducer(){
        //创建生产者
        producer = new DefaultMQProducer(producerGroup);
        //不开启vip通道
        producer.setVipChannelEnabled(false);
        //设定 name server
        producer.setNamesrvAddr(RocketEnum.NAME_SERVER.getValue());
        //producer.m
        start();
    }

    //使producer启动
    public void start(){
        try {
            this.producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }
    //返回producer
    public DefaultMQProducer getProducer(){
        return this.producer;
    }

    //进行关闭的方法
    public void shutdown(){
        this.producer.shutdown();
    }
}
