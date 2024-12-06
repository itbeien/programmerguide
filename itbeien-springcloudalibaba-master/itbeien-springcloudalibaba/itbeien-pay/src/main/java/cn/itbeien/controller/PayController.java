package cn.itbeien.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author beien
 * @date 2024-04-08 15:11
 * Copyright© 2024 beien
 */
@RestController
@RequestMapping("api")
@Slf4j
public class PayController {
    @RequestMapping(value = "doPay",method = RequestMethod.GET)
    public String doPay(){
        log.info("商城服务调用支付服务...");
        return "doPay";
    }
}
