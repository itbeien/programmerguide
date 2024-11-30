package cn.itbeien.pay.service;

import cn.itbeien.api.IPayService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;


/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
@DubboService
@Slf4j
public class PayService implements IPayService {
    @Override
    public String pay(String data) {
        log.info("进入到dubbo版本支付系统{}",data);
        return "OK";
    }
}
