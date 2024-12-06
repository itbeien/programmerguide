package cn.itbeien.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author beien
 * @date 2024-04-14 8:54
 * Copyright© 2024 beien
 */
@FeignClient(name = "card-service")
public interface CardFeignService {
    @PostMapping(value = "/api/voucher-pay")
    String callVoucherPay(JSONObject data);
}
