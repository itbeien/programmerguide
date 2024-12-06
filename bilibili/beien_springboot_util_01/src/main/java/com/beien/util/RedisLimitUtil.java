package com.beien.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 *  接口限流
 *
 */
@Slf4j
@Component
public class RedisLimitUtil {
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 限流
     * @param key   键
     * @param count 限流次数
     * @param times 限流时间
     * @return
     */
    public boolean limit(String key, int count, int times) {
        try {
            String script = "local lockKey = KEYS[1]\n" +
                    "local lockCount = KEYS[2]\n" +
                    "local lockExpire = KEYS[3]\n" +
                    "local currentCount = tonumber(redis.call('get', lockKey) or \"0\")\n" +
                    "if currentCount < tonumber(lockCount)\n" +
                    "then\n" +
                    "redis.call(\"INCRBY\", lockKey, \"1\")\n" +
                    "redis.call(\"expire\", lockKey, lockExpire)\n" +
                    "return true\n" +
                    "else\n" +
                    "return false\n" +
                    "end";
            RedisScript<Boolean> redisScript = new DefaultRedisScript<>(script, Boolean.class);
            List<String> keys = Arrays.asList(key, String.valueOf(count), String.valueOf(times));
            log.info("key:{}",key);
            return redisTemplate.execute(redisScript, keys);
        } catch (Exception e) {
            log.error("限流脚本执行失败：{}", e.getMessage());
        }
        return false;
    }
}
