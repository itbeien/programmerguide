package cn.itbeien.kafka.service;

import cn.itbeien.kafka.vo.SampleMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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
    private final List<SampleMessage> messages = new CopyOnWriteArrayList<>();

    @KafkaListener(topics = "itbeienTopic")
    void processMessage(SampleMessage message) {
        this.messages.add(message);
        log.info("Received sample message [" + message + "]");
    }

    public List<SampleMessage> getMessages() {
        return this.messages;
    }
}
