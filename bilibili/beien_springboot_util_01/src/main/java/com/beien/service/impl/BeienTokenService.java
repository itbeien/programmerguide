package com.beien.service.impl;

import com.beien.service.IBeienTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class BeienTokenService implements IBeienTokenService {
    @Autowired
    private StringRedisTemplate redisTemplate;
    private static final String TOKEN_PREFIX="beien_token:";

    /**
     * 生成token
     * @param userId
     * @return
     */
    @Override
    public String createToken(String userId) {
        //token 使用 uuid生成
        String token = UUID.randomUUID().toString();
        // 设置存入缓存的Key
        String key = TOKEN_PREFIX + token;
        //存储Token到分布式缓存,并且设置过期时间为2分钟
        redisTemplate.opsForValue().set(key, userId, 2, TimeUnit.MINUTES);
        //返回Token
        return token;
    }

    @Override
    public Boolean validateToken(String token, String userId) {
        //设置Lua脚本,其中 KEYS[1]是key,KEYS[2]是value
        String script = "if redis.call('get', KEYS[1]) == KEYS[2] then return redis.call('del', KEYS[1]) else return 0 end";
        RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
        //根据Key前缀拼接Key
        String key = TOKEN_PREFIX + token;
        //执行Lua脚本
        Long result = redisTemplate.execute(redisScript, Arrays.asList(key, userId));
        // 根据返回结果判断是否成功成功匹配并删除Redis键值对，若果结果不为空和0，则验证通过
        if (result != null && result != 0L) {
            log.info("验证 token={},key={},value={} 成功", token, key, userId);
            return true;
        }
        log.info("验证 token={},key={},value={} 失败", token, key, userId);
        return false;
    }
}
