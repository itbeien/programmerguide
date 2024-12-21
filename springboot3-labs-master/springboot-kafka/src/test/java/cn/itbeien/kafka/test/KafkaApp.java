package cn.itbeien.kafka.test;

import cn.itbeien.kafka.service.ProducerService;
import cn.itbeien.kafka.vo.SampleMessage;
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
public class KafkaApp {
    @Autowired
    private ProducerService producerService;

    @Test
    public void test() throws Exception{
        SampleMessage sampleMessage = new SampleMessage(1,"hello itbeien");
        producerService.send(sampleMessage);
        Thread.sleep(10000);
    }
}