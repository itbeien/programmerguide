package cn.itbeien.rabbitmq.test;

import cn.itbeien.rabbitmq.service.ProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
@SpringBootTest
public class RabbitMQApp {
    @Autowired
    private ProducerService producerService;

    @Test
   public void test() throws Exception{
        producerService.sendMsg();
        Thread.sleep(10000);
   }
}