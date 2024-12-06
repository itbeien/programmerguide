package com.beien;

import com.beien.annotation.Limit;
import com.beien.enums.LimitType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 接口限流有哪几种实现方式
 * 1.基于Redis+Lua脚本
 * 第一步 自定义限流注解
 * 第二步 限流类型枚举类
 * 第三步 限流 Lua 脚本
 * 第四步 限流切面处理类
 * 2.google的guava,令牌桶算法实现单机限流
 * Guava的 RateLimiter提供了令牌桶算法实现：
 * 平滑突发限流(SmoothBursty)和平滑预热限流(SmoothWarmingUp)实现
 * 3.阿里开源Sentinel https://github.com/alibaba/Sentinel
 * 4.interceptor+redis根据注解限流(Springboot+redis+注解+拦截器限流)
 */
@MapperScan
//@ComponentScan
@SpringBootApplication
@RestController
public class ApiLimitApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiLimitApplication.class, args);
    }

    @Limit(type = LimitType.DEFAULT, time = 10, count = 2)
    @GetMapping("api")
    public String test() {
        return "请求成功：" + System.currentTimeMillis();
    }


}
