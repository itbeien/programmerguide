package com.beien;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


/**
 * @author beien
 * @date 2023/3/13 15:23
 * Copyright© 2023 beien
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        // 此处暂时返回固定 master 数据源, 后面按动态策略修改
       // return DataSourceConstants.DS_KEY_MASTER;
        return DynamicDataSourceContextHolder.getContextKey();

    }

}
