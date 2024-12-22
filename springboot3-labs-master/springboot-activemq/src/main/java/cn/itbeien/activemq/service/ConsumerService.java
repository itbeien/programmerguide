package cn.itbeien.activemq.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
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

    @JmsListener(destination = "itbeienTopic")
    public void processMessage(String content) {
        log.info("消费者消费消息:{}",content);
    }
}
