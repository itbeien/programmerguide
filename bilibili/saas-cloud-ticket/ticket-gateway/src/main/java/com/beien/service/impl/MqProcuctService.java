package com.beien.service.impl;

import com.alibaba.fastjson.JSON;
import com.beien.enums.RocketEnum;
import com.beien.service.IMqProductService;
import com.beien.service.product.BeienProducer;
import com.beien.util.TimeUtil;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author beien
 * @date 2023/3/11 9:36
 * Copyright© 2023 beien
 */
@Service
public class MqProcuctService implements IMqProductService {

    @Resource
    private BeienProducer producer;
    @Override
    public void createMsg(String msg) {
        producer = new BeienProducer();
        //String msgJson = JSON.toJSONString(msg);
        //生成一个信息，标签在这里手动指定
        Message message = new Message(RocketEnum.TOPIC.getValue(),msg.getBytes());
        //messageDelayLevel=1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h 1d
        message.setDelayTimeLevel(1);
        //发送信息
        SendResult sendResult = null;
        try {
            sendResult = producer.getProducer().send(message);
        } catch (MQClientException e) {
            throw new RuntimeException(e);
        } catch (RemotingException e) {
            throw new RuntimeException(e);
        } catch (MQBrokerException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("时间:"+ TimeUtil.getNow("yyyy-mm-dd hh:mm:ss")+";生产者发送一条信息，内容:{"+msg+"},结果:{"+sendResult+"}");
    }
}
