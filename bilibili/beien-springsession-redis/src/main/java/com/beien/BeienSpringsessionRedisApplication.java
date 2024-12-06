package com.beien;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession  //开启使用Redis作为Session
public class BeienSpringsessionRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeienSpringsessionRedisApplication.class, args);
	}

}
