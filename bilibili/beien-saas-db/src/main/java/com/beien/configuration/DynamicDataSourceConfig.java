package com.beien.configuration;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.beien.DynamicDataSource;
import com.beien.constants.DataSourceConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author beien
 * @date 2023/3/12 10:26
 * Copyright© 2023 beien
 */
@Configuration  //数据多数据源配置切换类
public class DynamicDataSourceConfig {
    @Bean(name = DataSourceConstants.DS_KEY_MASTER)  //主库   spirng ioc 内存  集合 io  三级缓存
    @ConfigurationProperties("spring.datasource.master")  //切面
    public DataSource firstDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = DataSourceConstants.DS_KEY_SLAVE) //从库
    @ConfigurationProperties("spring.datasource.second")
    public DataSource secondDataSource(){
        return DruidDataSourceBuilder.create().build();
    }



    @Bean
    @Primary //创建数据源的标识
    public DataSource dynamicDataSource() {
        Map<Object, Object> dataSourceMap = new HashMap<>(2);
        //两个数据源存放在datasource
        dataSourceMap.put(DataSourceConstants.DS_KEY_MASTER, firstDataSource());
        dataSourceMap.put(DataSourceConstants.DS_KEY_SLAVE, secondDataSource());
        //设置动态数据源
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        dynamicDataSource.setDefaultTargetDataSource(firstDataSource());//设置默认数据源

        return dynamicDataSource;
    }
}
