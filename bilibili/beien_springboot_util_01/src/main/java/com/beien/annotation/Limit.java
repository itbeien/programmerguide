package com.beien.annotation;

import com.beien.enums.LimitType;

import java.lang.annotation.*;

/**
 * 限流注解
 * @author beien
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface  Limit {
    /**
     * 限流key前缀
     */
    String prefix() default "limit:";
    /**
     * 限流时间,单位秒
     */
    int time() default 60;
    /**
     * 限流次数
     */
    int count() default 10;
    /**
     * 限流类型
     */
    LimitType type() default LimitType.DEFAULT;
}
