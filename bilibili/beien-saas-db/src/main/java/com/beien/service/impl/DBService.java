package com.beien.service.impl;

import com.beien.DynamicDataSourceContextHolder;
import com.beien.constants.DataSourceConstants;
import com.beien.dao.DBDao;
import com.beien.service.IDBService;
import org.springframework.stereotype.Service;
import  com.beien.entity.Order;

import javax.annotation.Resource;

/**
 * @author beien
 * @date 2023/3/17 8:55
 * Copyright© 2023 beien
 */
@Service("dbService")
public class DBService implements IDBService {
    @Resource
    private DBDao dbDao;
    @Override
    public String executeCreateTableSQL() {
       String entityName =  Order.class.getName();
        String createSQL = dbDao.selectCreateTable(entityName);
        String spCode = "s0001";//客户端传入
        createSQL = createSQL.replace("${tablePrefix}",spCode);

        //获取 spCode,createTableSQL  公共库
        //切换数据库为租户库
        DynamicDataSourceContextHolder.setContextKey(DataSourceConstants.DS_KEY_SLAVE);
        this.dbDao.executeCreateTableSQL(createSQL);
        return null;
    }
}
