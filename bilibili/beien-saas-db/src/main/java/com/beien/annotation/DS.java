package com.beien.annotation;

import com.beien.constants.DataSourceConstants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author beien
 * @date 2023/3/13 15:39
 * Copyright© 2023 beien
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DS {
    /**
     * 数据源名称
     */
    String value() default DataSourceConstants.DS_KEY_MASTER;
}
