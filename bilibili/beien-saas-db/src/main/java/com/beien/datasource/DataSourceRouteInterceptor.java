package com.beien.datasource;

import com.beien.enums.DataSource;
import com.beien.enums.DatasourceConstantPropertiKey;
import com.beien.enums.DbReadWriteModel;
import com.beien.util.spring.SpringUtils;
import org.apache.ibatis.binding.BindingException;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

/**
 * @author itbeien.cn
 * @date 2023/5/23
 * 在执行数据库之前要切换到对应数据源->路由
 * @Company:itbeien.cn
 * @Copyright:Copyright(c)2023
 */
@Intercepts(value = {
        @Signature(type = StatementHandler.class,
                method = "prepare",
                args = {Connection.class, Integer.class})})
public class DataSourceRouteInterceptor implements Interceptor {
    private static final Logger logger = LoggerFactory.getLogger(DataSourceRouteInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        try {
            //继续执行逻辑
            return invocation.proceed();
        } catch (Throwable t) {
            throw t;
        } finally {
            DataSourceContextHolder.clearDBType();
        }
    }

    @Override
    public Object plugin(Object o) {
        DbReadWriteModel dbReadWriteModel = null;
        try {
            //获取代理权
            if (o instanceof DefaultParameterHandler) {
                Object object = ((DefaultParameterHandler) o).getParameterObject();
                MappedStatement mappedStatement = null;
                Field field = getFieldValueByFieldName((DefaultParameterHandler) o, "mappedStatement");
                mappedStatement = (MappedStatement) getFieldValue((DefaultParameterHandler) o, field);
                String mapperName = mappedStatement.getId().substring(0, mappedStatement.getId().lastIndexOf("."));
                DataSource routeDataSource = Class.forName(mapperName).getAnnotation(DataSource.class);
                logger.info("db mapper name:{}", mapperName);
                if (routeDataSource == null) {
                    throw new Exception("datasource Annotation is null! please config com.mopon.root.saas.ds.util.DataSource Annotation! ");
                }
                dbReadWriteModel = routeDataSource.value();
                if (object instanceof MapperMethod.ParamMap) {
                    long start = System.currentTimeMillis();
                    Map<Object, Object> dataSourceMap = DynamicDataSource.getInstance().getDataSourceMap();
                    MapperMethod.ParamMap map = (MapperMethod.ParamMap) object;

                    routeDefaultDataSource(dbReadWriteModel);

                    final String tenantCode = (String) map.get("tenantCode");

                    if (tenantCode == null) {
                        throw new Exception("DAO method had not paramter of tenantCode");
                    }

                    DynDataSourceCache dynDataSourceCache = (DynDataSourceCache) SpringUtils.getBean("dynDataSourceCache");

                    Integer databaseId = dynDataSourceCache.getDataSourceKey(tenantCode, dbReadWriteModel);

                    //数据源-> 数据库  datasource01->数据库01
                    //   datasource02->数据库02
                    String dbSourceKey = DatasourceConstantPropertiKey.DATASOURCEFLAG.getKey() + tenantCode + dbReadWriteModel + databaseId;

                    if (dataSourceMap.get(dbSourceKey) == null && DbReadWriteModel.READ.equals(dbReadWriteModel)) {
                        databaseId = dynDataSourceCache.getDataSourceKey(tenantCode, DbReadWriteModel.READ_WRITE);
                        dbSourceKey = DatasourceConstantPropertiKey.DATASOURCEFLAG.getKey() + tenantCode + DbReadWriteModel.READ_WRITE + databaseId;
                    }

                    if (dataSourceMap.get(dbSourceKey) != null) {
                        DataSourceContextHolder.setDBType(dbSourceKey);
                    }

                    logger.info("datasource route plugin take up time {} ms", (System.currentTimeMillis() - start));
                } else {
                    routeDefaultDataSource(dbReadWriteModel);
                    logger.info("dao mapper params is null !");
                }
                MDC.put("tenantDbInfo", DataSourceContextHolder.getDBType());
            }
        } catch (BindingException e) {
            logger.warn("param bindingException  tenantCode is null");
        } catch (Exception e) {
            logger.error("datasource route happen exceptions:", e);
        }
        return Plugin.wrap(o, this);
    }


    public static Object getFieldValue(Object obj, Field field) {
        Object value = null;
        //开启反射获取私有属性值
        field.setAccessible(true);
        try {
            value = field.get(obj);
        } catch (IllegalAccessException e) {
            logger.error("DataSourceRouteInterceptor.getFieldValue happen Exception e:", e);
        }
        return value;
    }

    public static Field getFieldValueByFieldName(Object object, String fieldName) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            //对private的属性的访问
            field.setAccessible(true);
            return field;
        } catch (Exception e) {
            logger.error("DataSourceRouteInterceptor.getFieldValueByFieldName happen Exception e:", e);
            return null;
        }
    }

    private void routeDefaultDataSource(DbReadWriteModel dbReadWriteModel) {
        if (DbReadWriteModel.READ_WRITE.equals(dbReadWriteModel)) {
            DataSourceContextHolder.setDBType(DatasourceConstantPropertiKey.DEFAULT_MASTER.getKey());
        } else {
            DataSourceContextHolder.setDBType(DatasourceConstantPropertiKey.DEFAULT_SLAVE.getKey());
        }
    }

    @Override
    public void setProperties(Properties properties) {
        //读取mybatis配置文件中属性
    }

}
