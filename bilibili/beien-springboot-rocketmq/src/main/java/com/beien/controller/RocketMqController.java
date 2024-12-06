package com.beien.controller;

import com.alibaba.fastjson.JSON;
import com.beien.OrderMsg;
import com.beien.enums.RocketEnum;
import com.beien.service.BeienProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.rocketmq.client.producer.SendResult;
import com.beien.util.TimeUtil;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author beien
 * @date 2023/3/5 16:22
 * Copyright© 2023 beien
 * 限时订单测试类
 */
@RestController
public class RocketMqController {
    @Autowired
    private BeienProducer producer;

    //初始化并发送消息,生产者 生产消息  延迟发送订单创建成功->消费者
    @RequestMapping("/send")
    public String send() throws Exception {
        int userId = 1;
        //得到订单编号:
        DateTimeFormatter df_year = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        LocalDateTime date = LocalDateTime.now();
        String datestr = date.format(df_year);

        //消息,指定用户id和订单编号  ->消息ID
        OrderMsg msg = new OrderMsg();
        msg.setUserId(userId);
        msg.setOrderId(userId+"_"+datestr);

        String msgJson = JSON.toJSONString(msg);
        //生成一个信息，标签在这里手动指定
        Message message = new Message(RocketEnum.TOPIC.getValue(),msgJson.getBytes());
        //delaytime的值:
        //延时消息  购买电影票成功->创建订单（支付：待支付）->等待用户支付
        //对订单的操作时间不能超过15分钟
        //发送订单创建成功的消息-生产者（延迟发送）->broker->消费方(检查当前这笔订单支付状态)->修改订单状态为过期状态
        //对电影票座位进行解锁
        //messageDelayLevel=1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h 1d
        message.setDelayTimeLevel(5);
        //发送信息
        SendResult sendResult = producer.getProducer().send(message);
        System.out.println("时间:"+ TimeUtil.getNow("yyyy-mm-dd hh:mm:ss")+";生产者发送一条信息，内容:{"+msgJson+"},结果:{"+sendResult+"}");

        return "success";
    }
}
