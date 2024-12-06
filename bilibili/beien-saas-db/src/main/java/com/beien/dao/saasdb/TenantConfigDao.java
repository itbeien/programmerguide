package com.beien.dao.saasdb;

import com.beien.entity.DatabaseConfig;
import com.beien.enums.DataSource;
import com.beien.enums.DbReadWriteModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Ben
 * @date 2020/3/25 9:38
 * @Company:Mopon
 * @Copyright:Copyright(c)2019
 */
@DataSource(DbReadWriteModel.READ_WRITE)
public interface TenantConfigDao {

    public DatabaseConfig findDatabaseConfigByDatabaseId(@Param("id") Integer id);

}
