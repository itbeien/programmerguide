package cn.itbeien.redisson.test;

import cn.itbeien.redisson.service.LockService;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedissonApplication {
    @Autowired
    private LockService lockService;
    /**
     * 进行性能测试
     */
    @Rule
    public ContiPerfRule contiPerfRule = new ContiPerfRule();

    /**
     * threads：线程池数量n，并发执行n个线程；
     * invocations：执行次数n，与线程数量无关，默认值为1；
     * duration：重复执行时间n，测试至少执行n毫秒；
     * 同时添加invocations和duration时，执行二者中测试数多的。
     * 并发执行测试分布式锁是否生效
     */
    @Test
    @PerfTest(invocations = 5,threads = 5)
    public void test(){
        lockService.doLock();
    }
}