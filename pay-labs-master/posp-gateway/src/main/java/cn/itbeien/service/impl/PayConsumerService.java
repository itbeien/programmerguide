package cn.itbeien.service.impl;

import cn.itbeien.enums.ServiceInstanceEnum;
import cn.itbeien.service.IPayConsumerService;
import cn.itbeien.service.feign.PayFeign;
import cn.itbeien.vo.PaymentVO;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
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
@Slf4j
public class PayConsumerService implements IPayConsumerService {

    @Resource
    private LoadBalancerClient loadBalancerClient;
    //@Resource
    private RestTemplate restTemplate;

    @Value("${spring.pay.application.name}")
    private String appName;

    @Autowired
    private PayFeign payFeign;

    @Override
    public String callPayService(JSONObject jsonObject) {
        String result = null;
        //使用 LoadBalanceClient 和 RestTemplate 结合的方式来访问
        //ServiceInstance serviceInstance = loadBalancerClient.choose(appName);
        //String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort());
        String url = String.format("http://%s",appName);
        url += ServiceInstanceEnum.PayServiceURL.getCode();
        log.info("request url:{}",url);
        //PaymentVO paymentVO = new PaymentVO();
        //对象转成JSONObject
        //JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(paymentVO));

        result = restTemplate.postForObject(url,jsonObject,String.class);
        return result;
    }

    @Override
    public String callFeignPayService(JSONObject jsonObject) {
        return payFeign.orderFromClient(jsonObject);
    }

    @Override
    public String callFeignSignService(JSONObject jsonObject) {
        return payFeign.signFromClient(jsonObject);
    }

    //实例化 RestTemplate 实例
     @Bean
     @LoadBalanced  //负载均衡
     public RestTemplate restTemplate(){
         this.restTemplate = new RestTemplate();
         return restTemplate;
     }

}
