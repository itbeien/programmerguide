package cn.itbeien.dynamic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * 没有@DS	默认数据源
 * @DS("dsName") dsName可以为组名也可以为具体某个库的名称
 * Copyright© 2024 itbeien
 */
@SpringBootApplication
@MapperScan
public class DynamicApplication {
    public static void main(String[] args) {
        SpringApplication.run(DynamicApplication.class,args);
    }
}