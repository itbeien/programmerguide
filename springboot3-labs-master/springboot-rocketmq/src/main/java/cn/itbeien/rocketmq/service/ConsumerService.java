package cn.itbeien.rocketmq.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;


/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
@Service
@RocketMQMessageListener(consumerGroup = "itbeien_group_1",topic = "itbeien-mq-topic")
@Slf4j
public class ConsumerService implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("message：{} ",message);
    }
}
