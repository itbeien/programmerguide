package com.beien.service.impl;

import com.beien.service.IPayConsumerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.annotation.Resource;


/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * 从服务注册中心发现pay服务并进行消费调用
 * Copyright© 2024 itbeien
 */
@Service
@EnableDiscoveryClient
public class PayConsumerService implements IPayConsumerService {
    @Resource
    private LoadBalancerClient loadBalancerClient;
    @Resource
    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String appName;

    @Value("${spring.application.url}")
    private String url;
    @Override
    public String callPayService() {
         url = null;
        //使用 LoadBalanceClient 和 RestTemplate 结合的方式来访问
        ServiceInstance serviceInstance = loadBalancerClient.choose(appName);
        String url = String.format("http://%s:%s/%s",serviceInstance.getHost(),serviceInstance.getPort(),appName);
        url = "http://"+appName+"/ticket?name=abc";
        System.out.println("request url:"+url);
        return restTemplate.getForObject(url,String.class);
    }

    //实例化 RestTemplate 实例
    @Bean
    @LoadBalanced  //负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
