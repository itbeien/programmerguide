package cn.itbeien.mybatis.nacos;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
@SpringBootApplication
@MapperScan
public class MyBatisNacosApplication {
    public static void main(String[] args) {
        //SpringApplication.run(MyBatisNacosApplication.class,args);
        //测试代码在src/test
    }
}