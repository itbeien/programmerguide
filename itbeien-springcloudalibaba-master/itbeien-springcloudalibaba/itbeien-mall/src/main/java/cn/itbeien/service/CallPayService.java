package cn.itbeien.service;

import cn.itbeien.fallback.PayServiceFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author beien
 * @date 2024-04-08 14:58
 * Copyright© 2024 beien
 */
@FeignClient(name = "pay-service",fallbackFactory = PayServiceFeignClientFallbackFactory.class)
public interface CallPayService {
    @RequestMapping(value = "/api/doPay/", method = RequestMethod.GET)
    String doPay();
}

