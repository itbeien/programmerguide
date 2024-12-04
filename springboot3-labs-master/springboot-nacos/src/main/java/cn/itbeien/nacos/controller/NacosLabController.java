package cn.itbeien.nacos.controller;


import cn.itbeien.nacos.config.NacosLabConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nacos-lab")
public class NacosLabController {
    @Autowired
    private NacosLabConfig nacosLabConfig;

    @GetMapping("test")
    public String test(){
        return nacosLabConfig.getKey();
    }
}
