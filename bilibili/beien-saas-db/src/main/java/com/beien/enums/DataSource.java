package com.beien.enums;

import java.lang.annotation.*;

/**
 * @author Ben
 * @date 2023/5/23 8:54
 * @Company:Mopon
 * @Copyright:Copyright(c)2019
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    DbReadWriteModel value();
}
