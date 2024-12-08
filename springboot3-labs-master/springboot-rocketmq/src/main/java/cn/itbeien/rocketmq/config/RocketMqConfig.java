package cn.itbeien.rocketmq.config;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * rocketmq配置信息
 * Copyright© 2024 itbeien
 */
@Configuration
public class RocketMqConfig {

    @Value("${rocketmq.name-server}")
    private String nameServer;

    @Value("${rocketmq.producer.group}")
    private String producerGroup;

    @Value("${rocketmq.producer.send-message-timeout}")
    private Integer sendMsgTimeout;

    @Value("${rocketmq.producer.max-message-size}")
    private Integer maxMessageSize;

    @Value("${rocketmq.producer.retry-times-when-send-failed}")
    private Integer retryTimesWhenSendFailed ;

    @Value("${rocketmq.producer.retry-times-when-send-async-failed}")
    private Integer retryTimesWhenSendAsyncFailed ;

    @Bean
    public RocketMQTemplate rocketMqTemplate(){
        RocketMQTemplate rocketMqTemplate = new RocketMQTemplate();
        rocketMqTemplate.setProducer(defaultMqProducer());
        return rocketMqTemplate;
    }

    @Bean
    public DefaultMQProducer defaultMqProducer() {
        DefaultMQProducer producer = new DefaultMQProducer();
        producer.setNamesrvAddr(this.nameServer);
        producer.setProducerGroup(this.producerGroup);
        producer.setSendMsgTimeout(this.sendMsgTimeout);
        producer.setMaxMessageSize(this.maxMessageSize);
        producer.setRetryTimesWhenSendFailed(this.retryTimesWhenSendFailed);
        producer.setRetryTimesWhenSendAsyncFailed(this.retryTimesWhenSendAsyncFailed);
        return producer;
    }
}
