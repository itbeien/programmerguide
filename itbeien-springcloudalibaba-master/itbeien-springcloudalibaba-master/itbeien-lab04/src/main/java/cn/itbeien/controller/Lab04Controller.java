package cn.itbeien.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author beien
 * @date 2024-04-14 8:36
 * Copyright© 2024 beien
 */
@RestController
public class Lab04Controller {
    @Value("${server.port}")
    private int port;

    /**
     * 卡消费接口
     * @param data
     * @return
     */
    @PostMapping("/api/voucher-pay")
    public String voucherPay(@RequestBody JSONObject data){
        String voucherId = data.getString("voucherId");//获取凭证号(卡号)
        return "port:"+port+" "+voucherId;
    }
}
