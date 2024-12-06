package cn.itbeien.controller;

import cn.itbeien.service.CardFeignService;
import cn.itbeien.service.CardService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author beien
 * @date 2024-04-13 16:56
 * Copyright© 2024 beien
 */
@RestController
public class Lab03Controller {

    @Autowired
    private CardService cardService;

    @Autowired
    private CardFeignService cardFeignService;


    /**
     * 用于消费预付卡交易系统卡消费功能
     * @return
     */
    @PostMapping("/api/card")
    public String callCard(String voucherId){
        String result = null;
        //使用RestTemplate进行服务负载调用(服务消费)
        result = cardService.callVoucherPay(voucherId);

        //使用openfeign进程服务负载调用(服务消费)
        JSONObject data = new JSONObject();
        data.put("voucherId",voucherId);
        String feignResult = cardFeignService.callVoucherPay(data);

        return result+" feign:"+feignResult;
    }
}
