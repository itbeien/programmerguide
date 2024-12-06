package com.beien.mutiltransaction;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author beien
 * @date 2023/3/14 16:25
 * Copyright© 2023 beien
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MutilDSProcessor.class)
public @interface EnableMutilTranactionManagement {
}
