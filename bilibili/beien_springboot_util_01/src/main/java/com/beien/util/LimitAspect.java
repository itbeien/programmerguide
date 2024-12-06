package com.beien.util;

import com.beien.annotation.Limit;
import com.beien.enums.LimitType;
import com.beien.exception.CustomerException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class LimitAspect {
    @Resource
    private RedisLimitUtil redisLimitUtil;

    /**
     * 前置通知，判断是否超出限流次数
     * @param point
     */
    @Before("@annotation(limit)")
    public void doBefore(JoinPoint point, Limit limit) {
        try {
            // 拼接key
            String key = getCombineKey(limit, point);
            // 判断是否超出限流次数
            if (!redisLimitUtil.limit(key, limit.count(), limit.time())) {
                throw new CustomerException("访问过于频繁，请稍候再试");
            }
        } catch (CustomerException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("接口限流异常，请稍候再试");
        }
    }
    /**
     * 根据限流类型拼接key
     */
    public String getCombineKey(Limit limit, JoinPoint point) {
        StringBuilder sb = new StringBuilder(limit.prefix());
        // 按照IP限流
        if (limit.type() == LimitType.IP) {
            sb.append(IPUtil.getIpAddr(HttpRequestUtil.getRequest())).append("-");
        }
        // 拼接类名和方法名
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Class<?> targetClass = method.getDeclaringClass();
        sb.append(targetClass.getName()).append("-").append(method.getName());
        return sb.toString();
    }
}
