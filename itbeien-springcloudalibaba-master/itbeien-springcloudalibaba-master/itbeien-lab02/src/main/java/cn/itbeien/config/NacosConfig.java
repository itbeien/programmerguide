package cn.itbeien.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author beien
 * @date 2024-04-13 8:35
 * Copyright© 2024 beien
 */
@Data
@Component
@RefreshScope //自动刷新
public class NacosConfig {

    @Value("${system.key}")
    private String key;
    @Value("${spring.datasource.url}")
    private String url;
}
