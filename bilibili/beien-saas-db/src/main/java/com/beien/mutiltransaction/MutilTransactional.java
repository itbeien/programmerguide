package com.beien.mutiltransaction;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author beien
 * @date 2023/3/14 16:23
 * Copyright© 2023 beien
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface MutilTransactional {
    String dataBase() default "dataSource";
    String []  ignoreMethod() default {"equals","hashCode","toString"};
    boolean readOnly() default false;
    boolean autoCommit() default  false;
    IsolationLevel isolationLevel() default IsolationLevel.TRANSACTION_DEFAULT;
}
