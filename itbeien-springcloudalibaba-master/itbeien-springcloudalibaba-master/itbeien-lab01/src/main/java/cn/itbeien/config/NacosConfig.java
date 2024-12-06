package cn.itbeien.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author beien
 * @date 2024-04-12 23:35
 * Copyright© 2024 beien
 */
@Data
@Component
@RefreshScope
public class NacosConfig {
    @Value("${system.key}")
    private String key;
}
