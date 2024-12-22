package cn.itbeien.activemq.test;


import cn.itbeien.activemq.service.ProducerService;
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
public class ActiveMQApp {
  @Autowired
  private ProducerService producerService;

    @Test
    public void test(){
        this.producerService.sendMsg("hello itbeien!");
    }
}