package cn.itbeien.sentinel.config;

import cn.itbeien.sentinel.SentinelNacosDataSourceHandler;
import com.alibaba.cloud.sentinel.SentinelProperties;
import com.alibaba.cloud.sentinel.custom.SentinelAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author beien
 * @date 2024-04-03 21:29
 * Copyright© 2024 beien
 * sentinel 规则持久化到 nacos 配置
 */
/*@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(SentinelAutoConfiguration.class)*/
public class SentinelNacosDataSourceConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public SentinelNacosDataSourceHandler sentinelNacosDataSourceHandler(SentinelProperties sentinelProperties){
        return new SentinelNacosDataSourceHandler(sentinelProperties);
    }

}
