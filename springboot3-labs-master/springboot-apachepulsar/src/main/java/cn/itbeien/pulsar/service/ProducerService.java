package cn.itbeien.pulsar.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.pulsar.core.PulsarTemplate;
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
public class ProducerService {
    private final PulsarTemplate<String> pulsarTemplate;

    public ProducerService(PulsarTemplate<String> pulsarTemplate) {
        this.pulsarTemplate = pulsarTemplate;
    }

    public void someMethod() {
        log.info("生产者者发送消息...");
        this.pulsarTemplate.send("itbeienTopic", "Hello itbeien!");
    }
}
