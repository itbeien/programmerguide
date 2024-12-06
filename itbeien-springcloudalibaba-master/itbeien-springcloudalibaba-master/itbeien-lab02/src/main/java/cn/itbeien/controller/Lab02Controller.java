package cn.itbeien.controller;

import cn.itbeien.config.NacosConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author beien
 * @date 2024-04-13 8:45
 * Copyright© 2024 beien
 */
@RestController
public class Lab02Controller {
    @Autowired
    private NacosConfig nacosConfig;

    @GetMapping("/lab02/config")
    public String config(){
        return nacosConfig.getUrl()+"----"+nacosConfig.getKey();
    }
}
