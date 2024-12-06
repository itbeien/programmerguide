package com.beien;

import com.beien.constants.DataSourceConstants;

/**
 * @author beien
 * @date 2023/3/13 15:36
 * Copyright© 2023 beien
 */
public class DynamicDataSourceContextHolder {
    /**
     * 动态数据源名称上下文
     * ThreadLocal  -》本地线程
     */
    private static final ThreadLocal<String> DATASOURCE_CONTEXT_KEY_HOLDER = new ThreadLocal<>();
    /**
     * 设置/切换数据源
     */
    public static void setContextKey(String key){
        DATASOURCE_CONTEXT_KEY_HOLDER.set(key);
    }
    /**
     * 获取数据源名称
     */
    public static String getContextKey(){
        String key = DATASOURCE_CONTEXT_KEY_HOLDER.get();
        return key == null? DataSourceConstants.DS_KEY_MASTER:key;
    }

    /**
     * 删除当前数据源名称
     */
    public static void removeContextKey(){
        DATASOURCE_CONTEXT_KEY_HOLDER.remove();
    }
}
