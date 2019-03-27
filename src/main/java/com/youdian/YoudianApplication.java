package com.youdian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.youdian.mapper")
@SpringBootApplication
//开启注解版缓存
@EnableCaching
public class YoudianApplication {

	public static void main(String[] args) {
		SpringApplication.run(YoudianApplication.class, args);
	}

}
