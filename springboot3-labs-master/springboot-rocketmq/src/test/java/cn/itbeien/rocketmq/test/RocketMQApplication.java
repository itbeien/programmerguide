package cn.itbeien.rocketmq.test;

import cn.itbeien.rocketmq.service.ProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
@SpringBootTest
public class RocketMQApplication {
    @Autowired
    private ProducerService producerService;
    /**
     * 生产消息
     */
    @Test
    public void sendMsg(){
        producerService.sendMsg1();
    }
}