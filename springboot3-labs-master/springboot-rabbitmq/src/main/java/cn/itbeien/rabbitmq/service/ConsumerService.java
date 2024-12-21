package cn.itbeien.rabbitmq.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
@Service
@Slf4j
public class ConsumerService {

    @RabbitHandler
    public void process(@Payload String foo) {
        log.info(foo);
    }


    @RabbitListener(queues = "itbeienQueue")
    public void processMessage(String content) {
        log.info("消费者消费消息:{}",content);
    }
}
