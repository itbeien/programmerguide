package cn.itbeien.redisson.config;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
@Configuration
@Slf4j
public class RedissonConfig {

    @Autowired
    private RedissonProperties redissonProperties;

    @Bean
    public RedissonClient redissonClient() throws Exception{
        Config config = Config.fromYAML(redissonProperties.getConfig());
        Redisson.create(config);
        log.info("Redisson 已启动");
        return Redisson.create(config);
    }
}
