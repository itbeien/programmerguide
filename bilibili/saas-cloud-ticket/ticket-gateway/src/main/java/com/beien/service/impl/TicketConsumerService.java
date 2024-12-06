package com.beien.service.impl;

import com.beien.service.ITicketConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author beien
 * @date 2023/3/11 11:01
 * Copyright© 2023 beien
 * 从服务注册中心发现ticket服务并进行消费调用
 */
@Service
@EnableDiscoveryClient
public class TicketConsumerService implements ITicketConsumerService {
    @Resource
    private LoadBalancerClient loadBalancerClient;
    @Resource
    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String appName;

    @Value("${spring.application.url}")
    private String url;
    @Override
    public String callTicketService() {
        //  url = null;
        //使用 LoadBalanceClient 和 RestTemplate 结合的方式来访问
        ServiceInstance serviceInstance = loadBalancerClient.choose(appName);
        String url = String.format("http://%s:%s/%s",serviceInstance.getHost(),serviceInstance.getPort(),appName);
        //url = "http://"+appName+"/ticket?name=abc";
        //System.out.println("request url:"+url);
        return restTemplate.getForObject(url,String.class);
    }

    //实例化 RestTemplate 实例
    @Bean
    @LoadBalanced  //负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
