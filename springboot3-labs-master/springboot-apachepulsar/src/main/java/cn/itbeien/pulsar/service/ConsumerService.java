package cn.itbeien.pulsar.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.pulsar.annotation.PulsarListener;
import org.springframework.stereotype.Component;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
@Component
@Slf4j
public class ConsumerService {

    @PulsarListener(topics = "itbeienTopic")
    public void processMessage(String content) {
        log.info("消费者接收到的消息:{}",content);
    }
}
