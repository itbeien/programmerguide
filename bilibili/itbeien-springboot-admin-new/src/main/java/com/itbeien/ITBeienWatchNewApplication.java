package com.itbeien;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author 程序员大同
 * @date 2023-05-19 14:37
 * Copyright© 2023 程序员大同
 *
 * 今天我们来一起搭建SpringBoot应用监控平台
 */
@SpringBootApplication
@EnableAdminServer
public class ITBeienWatchNewApplication {
    public static void main(String[] args) {
        SpringApplication.run(ITBeienWatchNewApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return applicationArguments -> {
            System.out.println("itbeiennewwatch启动成功！");
        };
    }
}
