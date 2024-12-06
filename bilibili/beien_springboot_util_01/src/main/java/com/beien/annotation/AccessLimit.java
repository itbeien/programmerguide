package com.beien.annotation;

import java.lang.annotation.*;

/**
 * @author beien
 * @date 2023-05-19 19:29
 * Copyright© 2023 beien
 */
@Documented
@Inherited
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessLimit {
    //标识 指定time时间段内的访问次数限制
    int limit() default 5;

    //标识 时间段
    int time() default 5;
}
