package com.beien.datasource;

import com.beien.entity.DatabaseConfig;
import com.beien.enums.DatasourceConstantPropertiKey;
import com.beien.service.ISaasModuleService;
import com.beien.util.SystemConfig;
import com.beien.util.encrypt.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 程序员大同
 * @date 2023/5/21 14:36
 * @Company:itbeien.cn
 * @Copyright:Copyright(c)2023
 */
@Component
public class DynamicDataSourceManager {

    @Autowired
    private ISaasModuleService saasModuleService;

    @Autowired
    private DriudDataSourceFactory driudDataSourceFactory;

    @Autowired
    private DynDataSourceCache dynDataSourceCache;

    /**
     * 创建租户数据源
     */
    public DynamicDataSource createDataSource(String tenantCode, Integer databaseId){
        Map<Object, Object> dataSourceMap = DynamicDataSource.getInstance().getDataSourceMap();
        
        DynamicDataSource dynamicDataSource = DynamicDataSource.getInstance();

        DatabaseConfig databaseConfig = this.saasModuleService.loadDatabaseConfig(databaseId);
        
        String dbSource = DatasourceConstantPropertiKey.DATASOURCEFLAG.getKey() + tenantCode + databaseConfig.getDbModel() + databaseId;

        Map<String, String> properties = new HashMap<>();
        properties.put(DatasourceConstantPropertiKey.MASTER_JDBC_DRIVERCLASS.getDataSourceKey(),databaseConfig.getDriverClassName());
        properties.put(DatasourceConstantPropertiKey.MASTER_JDBC_USER.getDataSourceKey(),databaseConfig.getDbUsername());
        String key = SystemConfig.getProperty(DatasourceConstantPropertiKey.DATABASE_CONFIG_ENCRYPT_KEY);
        properties.put(DatasourceConstantPropertiKey.MASTER_JDBC_PASSWORD.getDataSourceKey(), EncryptUtil.DES3DecryptFromStr(databaseConfig.getDbPassword(),key));
        properties.put(DatasourceConstantPropertiKey.MASTER_JDBC_DRIVERURL.getDataSourceKey(),databaseConfig.getDriverUrl());
        properties.put(DatasourceConstantPropertiKey.MASTER_JDBC_INITIALSIZE.getDataSourceKey(),String.valueOf(databaseConfig.getInitialSize()));
        properties.put(DatasourceConstantPropertiKey.MASTER_JDBC_MAXACTIVE.getDataSourceKey(),String.valueOf(databaseConfig.getMaxActive()));
        properties.put(DatasourceConstantPropertiKey.MASTER_JDBC_MAXPOOLPREPAREDSTATEMENTPERCONNECTIONSIZE.getDataSourceKey(),String.valueOf(databaseConfig.getMaxPoolPreparedStatementPerConnectionSize()));
        properties.put(DatasourceConstantPropertiKey.MASTER_JDBC_MAXWAIT.getDataSourceKey(),String.valueOf(databaseConfig.getMaxWait()));
        properties.put(DatasourceConstantPropertiKey.MASTER_JDBC_MINEVICTABLEIDLETIMEMILLIS.getDataSourceKey(),String.valueOf(databaseConfig.getMinEvictableIdleTimeMillis()));
        properties.put(DatasourceConstantPropertiKey.MASTER_JDBC_MINIDLE.getDataSourceKey(),String.valueOf(databaseConfig.getMinIdle()));
        properties.put(DatasourceConstantPropertiKey.MASTER_JDBC_POOLPREPAREDSTATEMENTS.getDataSourceKey(),databaseConfig.getPoolPreparedStatements());
        properties.put(DatasourceConstantPropertiKey.MASTER_JDBC_TESTONBORROW.getDataSourceKey(),databaseConfig.getTestOnBorrow());
        properties.put(DatasourceConstantPropertiKey.MASTER_JDBC_TESTWHILEIDLE.getDataSourceKey(),databaseConfig.getTestWhileIdle());
        properties.put(DatasourceConstantPropertiKey.MASTER_JDBC_TIMEBETWEENEVICTIONRUNSMILLIS.getDataSourceKey(),String.valueOf(databaseConfig.getTimeBetweenEvictionRunsMillis()));
        properties.put(DatasourceConstantPropertiKey.MASTER_JDBC_VALIDATIONQUERY.getDataSourceKey(),databaseConfig.getValidationQuery());
        properties.put("init","true");

        DataSource dataSource = driudDataSourceFactory.createDataSource(properties);
        if(dataSource != null){
            dataSourceMap.put(dbSource, dataSource);
            dynamicDataSource.setTargetDataSources(dataSourceMap);
            dynamicDataSource.setDefaultTargetDataSource(dataSource);
        }
        return dynamicDataSource;
    }


    /**
     * 关闭租户数据源
     */
    public void closeDataSource(String tenantCode, List<Integer> databaseIds){

        for(Integer databaseId : databaseIds) {
            DatabaseConfig databaseConfig = this.saasModuleService.loadDatabaseConfig(databaseId);
            String dbSource = DatasourceConstantPropertiKey.DATASOURCEFLAG.getKey() + tenantCode + databaseConfig.getDbModel() + databaseId;
            Map<Object, Object> dataSourceMap = DynamicDataSource.getInstance().getDataSourceMap();
            DataSource dataSource = (DataSource) dataSourceMap.get(dbSource);
            if (dataSource != null) {
                driudDataSourceFactory.closeDataSource(dataSource);
                dataSourceMap.remove(dbSource);
            }
            //key 租户+dbMode 下架数据源,清除本地数据缓存
            dynDataSourceCache.removeTenantToDBMap(tenantCode + databaseConfig.getDbModel(), databaseId);
        }
    }

}
