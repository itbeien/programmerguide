package com.beien.util;

import com.beien.annotation.GuavaLimit;
import com.beien.view.Message;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author beien
 * @date 2023-05-17 10:03
 * Copyright© 2023 beien
 * 使用AOP切面拦截限流注解
 */
@Slf4j
@Aspect
@Component
public class LimitAop {
    /**
     * 不同的接口，不同的流量控制
     * map的key为 Limiter.key
     */
    private final Map<String, RateLimiter> limitMap = Maps.newConcurrentMap();

    @Around("@annotation(com.beien.annotation.GuavaLimit)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        //拿limit的注解
        GuavaLimit guavaLimit = method.getAnnotation(GuavaLimit.class);
        if (guavaLimit != null) {
            //key作用：不同的接口，不同的流量控制，用于和接口绑定限制不同并发控制
            String key=guavaLimit.key();
            RateLimiter rateLimiter = null;
            //验证缓存是否有命中key
            if (!limitMap.containsKey(key)) {
                // 创建令牌桶
                rateLimiter = RateLimiter.create(guavaLimit.permitsPerSecond());
                limitMap.put(key, rateLimiter);
                log.info("新建了令牌桶={}，容量={}",key,guavaLimit.permitsPerSecond());
            }
            rateLimiter = limitMap.get(key);
            // 拿令牌
            boolean acquire = rateLimiter.tryAcquire(guavaLimit.timeout(), guavaLimit.timeunit());
            // 拿不到命令，直接返回异常提示
            if (!acquire) {
                Message message = new Message();
                log.error("令牌桶={}，获取令牌失败",key);
                message.setCode(9999);
                message.setMessage(guavaLimit.msg());
                return message;
            }
        }
        return joinPoint.proceed();
    }
}
