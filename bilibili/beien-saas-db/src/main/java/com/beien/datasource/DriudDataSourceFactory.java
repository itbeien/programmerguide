package com.beien.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Map;

/**
 * Driud数据源工厂
 * @author gyb
 * @since 0.1
 * @date 2016-04-12
 */
@Component
public class DriudDataSourceFactory extends AbstractDataSourceFactory {

   private static final Logger logger = LoggerFactory.getLogger(DriudDataSourceFactory.class);

    public DriudDataSourceFactory(){
        this.initMethod = "init";
        this.closeMethod = "close";
    }

    @Override
    public  DataSource createDataSource(Map<String, String> properties) {
        try {
            return DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            logger.error("create driudDataSource error", e);
            return null;
        }
    }
}
