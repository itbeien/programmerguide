package com.beien.util;

import com.alibaba.fastjson.JSON;
import com.beien.annotation.AccessLimit;
import com.beien.view.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author beien
 * @date 2023-05-19 19:31
 * Copyright© 2023 beien
 */
@Slf4j
public class AccessLimitInterceptor implements HandlerInterceptor {
    @Resource
    private RedisTemplate<String, Integer> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            if (!method.isAnnotationPresent(AccessLimit.class)) {
                return true;
            }
            AccessLimit accessLimit = method.getAnnotation(AccessLimit.class);
            if (accessLimit == null) {
                return true;
            }
            int limit = accessLimit.limit();
            int time = accessLimit.time();
            String key = request.getRequestURI();
            try {
                Integer maxLimit = redisTemplate.opsForValue().get(key);
                if (maxLimit == null) {
                    //set时一定要加过期时间
                    redisTemplate.opsForValue().set(key, 1, time, TimeUnit.SECONDS);
                } else if (maxLimit < limit) {
                    //方案一:
                    redisTemplate.opsForValue().set(key, maxLimit + 1, Objects.requireNonNull(redisTemplate.getExpire(key)), TimeUnit.SECONDS);


                } else {
                    Message message = new Message();
                    message.setCode(9999);
                    message.setMessage("请求过于频繁,请稍后再试!");
                    response.setCharacterEncoding("utf-8");
                    response.getWriter().write(JSON.toJSONString(message));
                    return false;
                }
            } catch (NullPointerException e) {
                redisTemplate.opsForValue().set(key, 1, time, TimeUnit.SECONDS);
            }
        }
        return true;

    }
}
