package cn.itbeien.kafka.service;

import cn.itbeien.kafka.vo.SampleMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
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

    private final KafkaTemplate<Object, SampleMessage> kafkaTemplate;

    ProducerService(KafkaTemplate<Object, SampleMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(SampleMessage message) {
        this.kafkaTemplate.send("itbeienTopic", message);
        log.info("Sent sample message [" + message + "]");
    }

}
