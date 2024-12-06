package cn.itbeien.controller;

import cn.itbeien.service.CallPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author beien
 * @date 2024-04-08 15:18
 * Copyright© 2024 beien
 */
@RestController
@RequestMapping("mall")
@Slf4j
public class MallController {
    @Autowired
    private CallPayService callPayService;

    @RequestMapping(value = "callPay",method = RequestMethod.GET)
    public String callPay(String data){
        log.info("浏览器调用商城服务...");
        String returnValue =  callPayService.doPay();
        return returnValue;
    }
}
