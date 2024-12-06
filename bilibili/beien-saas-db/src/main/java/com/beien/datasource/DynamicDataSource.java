package com.beien.datasource;

import com.beien.enums.DatasourceConstantPropertiKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 程序员大同
 * @date 2023/5/21 10:08
 * @Company:cn.itbeien
 * @Copyright:Copyright(c)2023
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSource.class);

    private static DynamicDataSource instance;
    private static Map<Object, Object> dataSourceMap = new ConcurrentHashMap<Object, Object>();

    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);
        dataSourceMap.putAll(targetDataSources);
        super.afterPropertiesSet();// 必须添加该句，否则新添加数据源无法识别到
    }

    public Map<Object, Object> getDataSourceMap() {
        return dataSourceMap;
    }

    public static synchronized DynamicDataSource getInstance() {
        if (instance == null) {
            instance = new DynamicDataSource();
        }
        return instance;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        String dbType = DataSourceContextHolder.getDBType();
        logger.info("DynamicDataSource determineCurrentLookupKey current datasource : {}", dbType);
        if (dbType == null) {
            dbType = DatasourceConstantPropertiKey.DEFAULT_MASTER.getKey();
            logger.info("DynamicDataSource determineCurrentLookupKey current datasource is null change default : {}", dbType);
        }
        return dbType;
    }

}