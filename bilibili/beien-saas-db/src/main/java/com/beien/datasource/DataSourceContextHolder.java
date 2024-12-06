package com.beien.datasource;

/**
 * @author Ben
 * @date 2020/1/6 10:07
 * @Company:Mopon
 * @Copyright:Copyright(c)2019
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static synchronized void setDBType(String dbType){
        contextHolder.set(dbType);
    }

    public static String getDBType(){
        return contextHolder.get();
    }

    public static void clearDBType(){
        contextHolder.remove();
    }
}
