package cn.itbeien;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author beien
 * @date 2024-04-14 8:35
 * Copyright© 2024 beien
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Lab04Application {
    public static void main(String[] args) {
        SpringApplication.run(Lab04Application.class,args);
    }
}
