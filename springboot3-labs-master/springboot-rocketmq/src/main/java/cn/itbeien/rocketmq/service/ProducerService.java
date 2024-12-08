package cn.itbeien.rocketmq.service;

import cn.itbeien.rocketmq.vo.MessageVO;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ProducerService
{
    @Autowired
    private RocketMQTemplate rocketMqTemplate;

    @Autowired
    private DefaultMQProducer defaultMqProducer ;
    public String sendMsg1 (){
        try {
            // 构建消息主体
            String msgBody = JSONObject.toJSONString(new MessageVO(1,"itbeien_mq_msg"));
            // 发送消息
            rocketMqTemplate.convertAndSend("itbeien-mq-topic",msgBody);
        } catch (Exception e) {
            log.error("发送消息异常:{}",e);
        }
        return "success" ;
    }



    public String sendMsg2 (){
        try {
            // 构建消息主体
            String msgBody = JSONObject.toJSONString(new MessageVO(1,"itbeien_mq_msg"));
            // 构建消息对象
            Message message = new Message();
            message.setTopic("itbeien-mq-topic");
            message.setTags("itbeien-mq-tag");
            message.setKeys("itbeien-mq-key");
            message.setBody(msgBody.getBytes());
            // 发送消息，打印日志
            SendResult sendResult = defaultMqProducer.send(message);
            log.info("msgId:{},sendStatus:{}",sendResult.getMsgId(),sendResult.getSendStatus());
        } catch (Exception e) {
            log.error("发送消息异常:{}",e);
        }
        return "success" ;
    }


}
