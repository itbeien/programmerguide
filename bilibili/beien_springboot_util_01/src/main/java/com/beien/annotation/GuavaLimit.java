package com.beien.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @author beien
 * @date 2023-05-17 10:00
 * Copyright© 2023 beien
 * 自定义限流注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface GuavaLimit {
    /**
     * 资源的key,唯一
     * 不同的接口，不同的流量控制
     */
    String key() default "";

    /**
     * 最多的访问限制次数
     */
    double permitsPerSecond () ;

    /**
     * 获取令牌最大等待时间
     */
    long timeout();

    /**
     * 获取令牌最大等待时间,单位(例:分钟/秒/毫秒) 默认:毫秒
     */
    TimeUnit timeunit() default TimeUnit.MILLISECONDS;

    /**
     * 得不到令牌的提示语
     */
    String msg() default "系统繁忙,请稍后再试!";
}
