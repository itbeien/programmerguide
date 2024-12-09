package cn.itbeien.redisson.service;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
@Service
@Slf4j
public class LockService {
    private final RedissonClient redissonClient;

    public LockService(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    public void doLock() {
        /***
         * 获取锁对象
         * RLock：这是 Redisson 提供的分布式锁对象。通过 RedissonClient.getLock() 方法可以获取到一个分布式锁。
         */
        RLock lock = redissonClient.getLock("itbeienLock");

        try {
            /**
             * tryLock(long waitTime, long leaseTime, TimeUnit unit)：此方法尝试获取锁，其中：
             * waitTime 是最大等待时间，表示在该时间内如果未获取到锁则放弃。
             * leaseTime 是锁的自动释放时间，避免因为业务逻辑异常导致锁无法释放。
             * 尝试获取锁，等待时间 100ms，锁定时间 8秒
             */
            if (lock.tryLock(100, 8, TimeUnit.SECONDS)) {
                try {
                    // 加锁成功，执行业务逻辑
                    log.info("锁定成功，执行业务逻辑...");
                    Thread.sleep(5000);  // 模拟执行业务逻辑
                } finally {
                    /**
                     * 释放锁
                     * unlock()：业务逻辑执行完后需要手动释放锁，否则其他线程将无法获取锁
                     */
                    lock.unlock();
                    log.info("业务逻辑已经执行完毕，已释放锁");
                }
            } else {
                log.info("无法获取锁，其他线程正在执行该任务");
            }
        } catch (InterruptedException e) {
            log.error("获取分布式锁异常:{}",e.getMessage());
        }
    }
}
