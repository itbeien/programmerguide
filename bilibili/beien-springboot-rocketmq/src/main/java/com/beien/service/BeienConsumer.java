package com.beien.service;

import com.beien.OrderMsg;
import com.beien.enums.RocketEnum;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import com.beien.util.TimeUtil;

import java.io.UnsupportedEncodingException;

/**
 * @author beien
 * @date 2023/3/5 16:08
 * Copyright© 2023 beien
 * 限时订单消费处理类，收到消息后需要坚持订单支付状态，如果订单支付状态为
 * 未支付状态则修改订单为关闭状态，并修改商品表库存
 *
 *
 */
@Component
public class BeienConsumer {
    //消费者实体对象
    private DefaultMQPushConsumer consumer;

    //消费者组
    public static final String CONSUMER_GROUP = "beien-rocketmq-test";

    //构造函数 用来实例化对象
    public BeienConsumer() throws MQClientException {
        consumer = new DefaultMQPushConsumer(CONSUMER_GROUP);
        consumer.setNamesrvAddr(RocketEnum.NAME_SERVER.getValue());
        //指定消费模式
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        //指定订阅主题
        //指定订阅标签，*代表所有标签
        consumer.subscribe(RocketEnum.TOPIC.getValue(), "*");
        //注册一个消费消息的Listener
        //对消息的消费在这里实现
        //两种回调 MessageListenerConcurrently 为普通监听，MessageListenerOrderly 为顺序监听
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            //遍历接收到的消息
            //1 监听消息的创建者发送消息  2 消息的消费（用户编号+订单号）
            //3 针对于消息id做业务处理(修改订单状态  解锁电影票对应的座位)
            try {
                for (Message msg : msgs) {
                    //得到消息的body
                    String body = new String(msg.getBody(), "utf-8");
                    //用json转成对象
                    OrderMsg msgOne = JSON.parseObject(body, OrderMsg.class);
                    //打印用户id
                    System.out.println("消息:用户id:"+msgOne.getUserId());
                    //打印订单编号
                    System.out.println("消息:订单sn:"+msgOne.getOrderId());
                    //打印消息内容
                    System.out.println("时间:"+ TimeUtil.getNow("yyyy-mm-dd hh:mm:ss")+";消费者已接收到消息-topic={"+msg.getTopic()+"}, 消息内容={"+body+"}");

                    System.out.println("接收到订单相关信息后完成后续业务逻辑，检查订单状态是否为未支付状态，如果为未支付状态" +
                            "则修改订单状态为关闭状态，并对商品库存进行修改");
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });

        consumer.start();
        System.out.println("消费者 启动成功=======");
    }
}
