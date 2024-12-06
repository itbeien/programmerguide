package cn.itbeien.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.List;

/**
 * @author beien
 * @date 2024-04-02 20:38
 * Copyright© 2024 beien
 */
@RestController
@RequestMapping("api")
@Slf4j
public class SentinelController {
    @Value ("${spring.cloud.nacos.config.server-addr}")
    private String remoteAddress;
    @Value ("${spring.cloud.nacos.config.group}")
    private String groupId;

    private String dataId = "itbeien-spring-cloud-sentinel-nacos.properties";

    @GetMapping("testSentinel")
    @SentinelResource(value = "itbeienSentinel",fallback="handlerException")
    public String test() {

       /* ReadableDataSource<String, List<FlowRule>> flowRuleDataSource = new NacosDataSource<>(remoteAddress, groupId, dataId, source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {}));
        FlowRuleManager.register2Property(flowRuleDataSource.getProperty());*/

        log.info("sentinel流控测试...");
        return "success";
    }

    public  String handlerException(Throwable exception) {
        return "请求太频繁，请稍后再试!";
    }

    //限流规则类
    public class ItbeienHandler {
        public  String handlerExceptionOne(BlockException exception) {
            return "10001, 服务不可用";
        }

        public  String handlerExceptionTwo(BlockException exception) {
            return "10002, 服务不可用";
        }

    }
}