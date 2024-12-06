package com.beien;

import com.beien.service.IUserService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;

import javax.annotation.Resource;

/*
 * Spring事务失效的8种场景
 * 1.标注错误的异常类型
 * @Tansactional注解中标注了错误的异常类型,则Spring事务的回滚会失效
 * Spring中默认回滚的事务异常类型为RuntimeException
 * 2.不正确的捕获异常
 * 3.方法的事务传播类型不支持事务
 * 4.未配置事务管理器
 * 5.同一类中的方法调用
 * 6.方法没有被public修饰
 * 7.事务方法未被Spring管理
 * 8.动态切换数据库时
 */
@SpringBootTest
@MapperScan
public class TransactionFailure {
    @Resource
    IUserService userService;
    @Test
    void contextLoads() throws Exception{
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        AnnotationConfigContextLoader annotationConfigContextLoader = new AnnotationConfigContextLoader();
        //annotationConfigWebContextLoader.processContextConfiguration();
        //IUserService userService = (IUserService) context.getBean("userService");
        //小明给贝恩转帐500
        //userService.transfer("贝恩","小明",500);

        userService.transfer1("贝恩","小明",500);
    }

}
