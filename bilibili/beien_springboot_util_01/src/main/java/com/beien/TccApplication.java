package com.beien;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 *TCC模式不依赖于底层数据资源的事务支持(需要编写代码实现提交和回滚)
 *一阶段 prepare行为:调用自定义的prepare逻辑
 *二阶段commit行为:调用自定义的commit逻辑
 *三阶段rollback行为:调用自定义的 rollback逻辑
*/
@MapperScan
@SpringBootApplication
@RestController
public class TccApplication {
    public static void main(String[]args){
        SpringApplication.run(TccApplication.class,args);
    }
}
