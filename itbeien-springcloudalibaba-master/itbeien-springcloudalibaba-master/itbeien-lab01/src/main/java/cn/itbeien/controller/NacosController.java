package cn.itbeien.controller;

import cn.itbeien.config.NacosConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author beien
 * @date 2024-04-12 23:47
 * Copyright© 2024 beien
 */
@RestController
public class NacosController {
    @Autowired
    private NacosConfig nacosConfig;
    @GetMapping("config")
    private String config(){
        return nacosConfig.getKey();
    }
}
