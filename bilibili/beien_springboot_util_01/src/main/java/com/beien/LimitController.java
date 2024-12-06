package com.beien;

import com.beien.annotation.GuavaLimit;
import com.beien.view.Message;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @author beien
 * @date 2023-05-17 8:48
 * Copyright© 2023 beien
 * guava limit
 */
@Slf4j
@RestController
@RequestMapping("/limit")
public class LimitController {
    /**
     * 限流策略 ：1秒钟2个请求
     */
    private final RateLimiter limiter = RateLimiter.create(2.0);

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @GetMapping("/limit.do")
    public Object testLimiter() {
        //500毫秒内，没拿到令牌，就直接进入服务降级(服务调用失败)
        boolean tryAcquire = limiter.tryAcquire(500, TimeUnit.MILLISECONDS);
        Message message = new Message();
        if (!tryAcquire) {
            log.warn("服务调用失败，时间{}", LocalDateTime.now().format(dtf));
            message.setMessage("当前请求人数较多，请稍后再试！");
            message.setCode(9999);
            return message;
        }

        log.info("获取令牌成功，时间{}", LocalDateTime.now().format(dtf));

        message.setMessage("请求成功");
        message.setCode(200);
        return message;
    }


    @GetMapping("/test2")
    @GuavaLimit(key = "testLimiter2", permitsPerSecond = 1, timeout = 500, timeunit = TimeUnit.MILLISECONDS,msg = "当前排队人数较多，请稍后再试！")
    public Object testLimiter2() {
        log.info("令牌桶testLimiter2获取令牌成功");
        Message message = new Message();
        message.setMessage("ok");
        message.setCode(200);
        return message;
    }
    @GetMapping("/test3")
    @GuavaLimit(key = "testLimiter3", permitsPerSecond = 2, timeout = 500, timeunit = TimeUnit.MILLISECONDS,msg = "系统错误，服务正在降级！")
    public Object testLimiter3() {
        log.info("令牌桶testLimiter3获取令牌成功");
        Message message = new Message();
        message.setMessage("ok");
        message.setCode(200);
        return message;
    }
}
