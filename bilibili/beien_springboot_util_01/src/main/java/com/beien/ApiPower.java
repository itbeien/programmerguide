package com.beien;


import com.beien.service.IBeienTokenService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
/**
 * 四种幂等性解决方案
 基于SpringBoot实现接口幂等性
 方案一：防重Token令牌如何实现幂等性？
 方案二：数据库唯一主键如何实现幂等性？
 方案三：数据库乐观锁如何实现幂等性？
 方案四:下游系统调用方传递唯一序列号如何实现幂等性？
 有哪些场景会用到幂等性
 1.下单  2.支付  3.验票
 *
 */
//@ComponentScan("com.beien")
@SpringBootApplication
@RestController
@MapperScan
public class ApiPower {
    @Resource
    private IBeienTokenService beienTokenService;
    public static void main(String[] args) {
        SpringApplication.run(ApiPower.class, args);
    }

    /**
     * 获取 Token 接口
     * @return token
     */
    @GetMapping("/initToken")
    public String initToken() {
        //获取用户信息（这里使用userId）
        //注：这里存储该内容只是举例，其作用为辅助验证，使其验证逻辑更安全，如这里存储用户信息，其目的为:
        //1.使用token验证 Redis 中是否存在对应的 Key
        //2.使用用户信息验证 Redis 的Value是否匹配。
        String userId = "beien";
        // 获取Token字符串,并返回
        return beienTokenService.createToken(userId);
    }

    /**
     * 接口幂等性测试接口
     *
     * @param token 幂等 Token
     * @return 执行结果
     */
    @PostMapping("/apiTest")
    public String test(@RequestHeader(value = "token") String token) {
        // 获取用户信息（这里使用模拟数据）
        String userId = "beien";
        //根据Token和与用户相关的信息到 Redis 验证是否存在对应的信息
        boolean result = beienTokenService.validateToken(token, userId);
        // 根据验证结果响应不同信息
        return result ? "执行后续业务逻辑" : "重复调用,不允许调用后续业务逻辑";
    }
}
