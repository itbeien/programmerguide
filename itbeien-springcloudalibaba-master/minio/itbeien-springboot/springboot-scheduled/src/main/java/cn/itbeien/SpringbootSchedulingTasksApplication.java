package cn.itbeien;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author beien
 * @date 2023-10-17 18:57
 * Copyright© 2023 beien
 */
@SpringBootApplication
//开启定时任务
@EnableScheduling
public class SpringbootSchedulingTasksApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSchedulingTasksApplication.class, args);
    }
}
