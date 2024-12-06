package cn.itbeien;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author beien
 * @date 2024-04-08 14:45
 * Copyright© 2024 beien
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MallApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class,args);
    }
}
