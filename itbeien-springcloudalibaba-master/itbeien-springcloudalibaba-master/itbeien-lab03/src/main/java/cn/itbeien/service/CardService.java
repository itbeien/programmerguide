package cn.itbeien.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author beien
 * @date 2024-04-14 8:48
 * Copyright© 2024 beien
 */
@Service
public class CardService {
    private static final String CARD_SERVICE = "card-service";

    private static final String VOUCHER_PAY = "/api/voucher-pay";


    //@Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        restTemplate =  new RestTemplate();
        return restTemplate;
    }

    public String callVoucherPay(String voucherId){
        String result  = null;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("voucherId",voucherId);
        String url  = "http://%s/%s";
        url = String.format(url,CARD_SERVICE,VOUCHER_PAY);
        result = restTemplate.postForObject(url,jsonObject,String.class);
        return result;
    }
}
