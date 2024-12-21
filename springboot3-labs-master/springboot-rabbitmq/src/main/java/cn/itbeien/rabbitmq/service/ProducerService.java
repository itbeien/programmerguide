package cn.itbeien.rabbitmq.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
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
public class ProducerService {

    private final AmqpAdmin amqpAdmin;

    private final AmqpTemplate amqpTemplate;

    @Bean
    public Queue itbeienQueue() {
        return new Queue("itbeienQueue");
    }

    public ProducerService(AmqpAdmin amqpAdmin ,AmqpTemplate amqpTemplate) {
        this.amqpAdmin = amqpAdmin;
        this.amqpTemplate = amqpTemplate;
    }

    public void sendMsg(){
        Message message = new Message("hello itbeien".getBytes());
        this.amqpTemplate.send("itbeienQueue",message);
        log.info("生产者发布消息...");
    }

}
