package com.beien;

import com.beien.pojo.UserInfo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 更好的保护用户信息-SpringBoot实现接口返回
 * 数据脱敏
 * 通过自定义注解给接口返回内容脱敏
 * 第一步：定义脱敏注解
 * 第二步：定义脱敏策略枚举
 * 第三步：定制JSON序列化实现对注解
 * @Sensitive的字段进行脱敏
 *
 * @author 贝恩
 */
@MapperScan
@SpringBootApplication
@RestController
public class SensitiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(SensitiveApplication.class,args);
    }

    @GetMapping("/sensitiveApi")
    public UserInfo sensitiveApi(){
        UserInfo user = new UserInfo();
        user.setId(10000);
        user.setAge(18);
        user.setName("贝恩");
        user.setPhone("18888888881");
        user.setAddress("深圳市南山区....");
        user.setIdCard("430211111111111012");
        user.setEmail("10001@qq.com");
        return user;
    }
}
