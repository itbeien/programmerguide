package com.beien;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class BeienSaasDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeienSaasDbApplication.class, args);
	}

}
