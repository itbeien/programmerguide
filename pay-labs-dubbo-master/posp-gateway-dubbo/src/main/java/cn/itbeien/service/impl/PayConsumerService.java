package cn.itbeien.service.impl;

import cn.itbeien.api.IPayService;
import cn.itbeien.service.IPayConsumerService;
import com.alibaba.fastjson2.JSONObject;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * 从服务注册中心发现pay服务并进行消费调用
 * Copyright© 2024 itbeien
 */
@Service
@Slf4j
public class PayConsumerService implements IPayConsumerService {

    @DubboReference
    private IPayService payService;

    @Override
    public String callPayService(JSONObject jsonObject) {
        log.info("进入到gateway调用支付服务方法...");
        return payService.pay(jsonObject.toJSONString());
    }


}
