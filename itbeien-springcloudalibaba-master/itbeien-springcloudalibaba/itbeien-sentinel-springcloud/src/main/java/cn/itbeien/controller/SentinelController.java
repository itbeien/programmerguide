package cn.itbeien.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author beien
 * @date 2024-04-02 14:42
 * Copyright© 2024 beien
 */
@RestController
@RequestMapping("api")
@Slf4j
public class SentinelController {

    /**
     * 测试限流方法，提供给浏览器访问
     * @return
     */
    @GetMapping("sentinel")
    @SentinelResource(value = "test",fallback="error")
    public String testSentinel(){
        //调用流量控制测试方法
        test();
        return "success";
    }

    /**
     * SentinelResource 流量控制注解
     * value = "test"和Sentinel管理后台的资源名称一样
     */
    @SentinelResource(value = "test"/*,blockHandler = "error"*/)
    public void test(){
       log.info("sentinel流量控制测试");
    }

    public String error(){
        log.error("流量控制异常");
        return "流量控制异常";
    }
}
