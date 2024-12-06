package com.beien.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author beien
 * @date 2023/3/10 17:05
 * Copyright© 2023 beien
 *
 * 动态创建数据库表
 * 1.在基础库建一张表维护建表的SQL
 * 2.在dao层新建一个方法->mapper里面的动态建表方法
 * 3.在service层获取建表的SQL，然后再动态替换业务运营商(景区)编号
 */
public interface DBDao {
    public Integer executeCreateDB(String dbName);
    public void executeCreateTableSQL(String createSQL);

    public String selectCreateTable(String entityName);
}
