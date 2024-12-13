package cn.itbeien.canal.util;

import cn.itbeien.canal.entity.SysUser;
import jakarta.annotation.Resource;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
@Component
public class RedisClient {

    @Resource
    private RedissonClient redissonClient;

    /**
     * 登录成功，将用户数据存放到redis
     * 往redis中存放数据
     * @param uid
     * @param sysUser
     */
    public void setUserToCacheById(String uid, SysUser sysUser){
        //获得一个RBucket实现类，参数是redis数据库中的key值
        RBucket<SysUser> bucket = redissonClient.getBucket(uid);
        //执行set语句，将user对象存入redis中
        bucket.set(sysUser,1000*60, TimeUnit.MILLISECONDS);
    }

    public void set(String uid, Object object){
        //获得一个RBucket实现类，参数是redis数据库中的key值
        RBucket<Object> bucket = redissonClient.getBucket(uid);
        //执行set语句，将user对象存入redis中
        bucket.set(object);
    }

    /**
     * 根据uid从缓存中获取用户数据
     * @param uid
     * @return
     */
    //@TestAnnotation
    public SysUser getUserToCacheById(String uid){
        //获得一个RBucket实现类，参数是redis数据库中的key值
        RBucket<SysUser> bucket = redissonClient.getBucket(uid);
        //从redis中获取用户信息
        return bucket.get();
    }
}
